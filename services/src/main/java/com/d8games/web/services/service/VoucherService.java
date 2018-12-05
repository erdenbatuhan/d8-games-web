package com.d8games.web.services.service;

import com.d8games.web.services.config.ConfigManager;
import com.d8games.web.services.exception.DuplicateVoucherException;
import com.d8games.web.services.exception.IllegalVoucherException;
import com.d8games.web.services.exception.NightHoursException;
import com.d8games.web.services.model.dto.VoucherDto;
import com.d8games.web.services.model.dto.VoucherItemDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.JobInfo;
import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.repository.VoucherRepository;
import com.d8games.web.services.util.DateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private JobInfoService jobInfoService;

    @Autowired
    private WorkInfoService workInfoService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MissingVoucherHistoryService missingVoucherHistoryService;

    public List<Voucher> getAllByEmployeeId(String employeeId) {
        return voucherRepository.getAllByEmployeeIdOrderByActualDateDesc(employeeId);
    }

    public Voucher getById(String id) {
        return voucherRepository.getVoucherById(id);
    }

    public List<VoucherItemDto> getVoucherItemDtoList(String employeeId) {
        return voucherRepository.getVoucherItemDtoList(employeeId);
    }

    public String addEmpty(String employeeId) {
        Voucher voucher = new Voucher();

        voucher.setType(ConfigManager.getVoucherNotApplicable());
        voucher.setLocation(ConfigManager.getVoucherNotApplicable());
        voucher.setExactVoucherDate(null);
        voucher.setActualDate(DateTime.parse("2000-01-01").toDate());
        voucher.setDate(ConfigManager.getVoucherNotApplicable());
        voucher.setDay(ConfigManager.getVoucherNotApplicable());
        voucher.setHour(ConfigManager.getVoucherNotApplicable());
        voucher.setAdmin(true);
        voucher.setEmployee(employeeService.getById(employeeId));

        voucherRepository.save(voucher);
        return voucher.getId();
    }

    @Scheduled(fixedRate = 7200000)
    public void performChecksForMissingVouchers() {
        Date currentDate = new Date();
        DateUtil dateUtil = new DateUtil(currentDate);

        if (DateUtil.isNight(dateUtil.getIntegerHour())) {
            List<Employee> employees = employeeService.getAll();

            for (Employee employee : employees) {
                List<VoucherDto> voucherDtoList = voucherRepository.getVoucherDtoList(employee.getId());

                if (voucherDtoList != null && voucherDtoList.size() > 0) {
                    VoucherDto lastVoucherDto = voucherDtoList.get(0);

                    if (lastVoucherDto.getType().equals(ConfigManager.getVoucherTypeIn()))
                        vouchOutForEmployee(employee, lastVoucherDto);
                }
            }
        }
    }

    private void vouchOutForEmployee(Employee employee, VoucherDto lastVoucherDto) {
        int hoursToAdd = ConfigManager.getVoucherNoOutPunishment();

        if (lastVoucherDto.getLocation().equals(ConfigManager.getVoucherLocationHome())) {
            JobInfo jobInfo = jobInfoService.getByEmployee(employee);
            hoursToAdd = (int) (jobInfo.getHomeHoursNeededPerMonth() / 4);
        }

        Date inDate = lastVoucherDto.getActualDate();
        Date outDate = DateUtil.getHoursAhead(lastVoucherDto.getActualDate(), hoursToAdd);

        String type = ConfigManager.getVoucherTypeOut();
        String location = lastVoucherDto.getLocation();

        Voucher voucher = add(inDate, outDate, type, location, employee);

        missingVoucherHistoryService.add(voucher);
        System.out.println(employee.getName() + " forgot to Vouch OUT. We have punished him/her!");
    }

    private Voucher add(Date inDate, Date outDate, String type, String location, Employee employee) {
        Voucher voucher = new Voucher();
        DateUtil outDateUtil = new DateUtil(outDate);

        setProperties(voucher, type, location, true, employee);
        setDates(voucher, outDateUtil);

        workInfoService.addHours(inDate, outDateUtil.getActualDate(), location, employee);
        voucherRepository.save(voucher);

        return voucher;
    }

    public String addWithLocation(String type, String location, String employeeId, boolean admin) {
        final String officeIp = ConfigManager.getOfficeIp();
        final String randomHomeIp = "99.999.999.999";

        if (location.equals(ConfigManager.getVoucherLocationOffice()))
            return add(type, officeIp, employeeId, admin);

        return add(type, randomHomeIp, employeeId, admin);
    }

    public String add(String type, String ip, String employeeId, boolean admin)
            throws NightHoursException, DuplicateVoucherException, IllegalVoucherException {
        final String officeIp = ConfigManager.getOfficeIp();
        final String locationOffice = ConfigManager.getVoucherLocationOffice();
        final String locationHome = ConfigManager.getVoucherLocationHome();

        Voucher voucher = new Voucher();
        DateUtil dateUtil = new DateUtil(new Date());
        String location = (officeIp.equals(ip)) ? locationOffice : locationHome;

        checkVoucherConstraints(dateUtil, type, location, employeeId);

        setProperties(voucher, type, location, admin, employeeService.getById(employeeId));
        setDates(voucher, dateUtil);

        if (type.equals(ConfigManager.getVoucherTypeOut()))
            addHours(dateUtil, location, employeeId);

        voucherRepository.save(voucher);
        return voucher.getId();
    }

    private void checkVoucherConstraints(DateUtil dateUtil, String type, String location, String employeeId)
            throws NightHoursException, DuplicateVoucherException, IllegalVoucherException {
        if (DateUtil.isNight(dateUtil.getIntegerHour()))
            throw new NightHoursException();

        List<VoucherDto> voucherDtoList = voucherRepository.getVoucherDtoList(employeeId);

        if (voucherDtoList == null || voucherDtoList.size() == 0)
            return;

        VoucherDto lastVoucherDto = voucherDtoList.get(0);

        if (type.equals(lastVoucherDto.getType()))
            throw new DuplicateVoucherException(type);

        if (type.equals(ConfigManager.getVoucherTypeOut())) {
            String voucherTypeInLocation = lastVoucherDto.getLocation();

            if (!location.equals(voucherTypeInLocation))
                throw new IllegalVoucherException(voucherTypeInLocation, location);
        }
    }

    private void setProperties(Voucher voucher, String type, String location, boolean admin, Employee employee) {
        voucher.setType(type);
        voucher.setLocation(location);
        voucher.setAdmin(admin);
        voucher.setEmployee(employee);
    }

    private void setDates(Voucher voucher, DateUtil dateUtil) {
        final Date actualDate = dateUtil.getActualDate();
        final String date = dateUtil.getDate();
        final String day = dateUtil.getDay();
        final String hour = dateUtil.getHour();

        voucher.setExactVoucherDate(new Date());
        voucher.setActualDate(actualDate);
        voucher.setDate(date);
        voucher.setDay(day);
        voucher.setHour(hour);
    }

    private void addHours(DateUtil dateUtil, String location, String employeeId) {
        List<VoucherDto> voucherDtoList = voucherRepository.getVoucherDtoList(employeeId);

        if (voucherDtoList != null && voucherDtoList.size() > 0) {
            VoucherDto lastVoucherDto = voucherDtoList.get(0);
            Employee employee = employeeService.getById(employeeId);

            workInfoService.addHours(lastVoucherDto.getActualDate(), dateUtil.getActualDate(), location, employee);
        }
    }
}
