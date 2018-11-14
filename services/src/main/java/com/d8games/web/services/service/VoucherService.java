package com.d8games.web.services.service;

import com.d8games.web.services.config.ConfigManager;
import com.d8games.web.services.exception.DuplicateVoucherException;
import com.d8games.web.services.exception.IllegalVoucherException;
import com.d8games.web.services.exception.NightHoursException;
import com.d8games.web.services.model.dto.VoucherDto;
import com.d8games.web.services.model.dto.VoucherItemDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.repository.VoucherRepository;
import com.d8games.web.services.util.DateUtil;
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
    private WorkInfoService workInfoService;

    @Autowired
    private EmployeeService employeeService;

    public List<Voucher> getAllByEmployeeId(String employeeId) {
        return voucherRepository.getAllByEmployeeIdOrderByActualDateDesc(employeeId);
    }

    public Voucher getById(String id) {
        return voucherRepository.getVoucherById(id);
    }

    public List<VoucherItemDto> getVoucherItemDtoList(String employeeId) {
        return voucherRepository.getVoucherItemDtoList(employeeId);
    }

    @Scheduled(fixedRate = 7200000)
    public void performChecksForForgottenOutVouchers() {
        Date currentDate = new Date();
        DateUtil dateUtil = new DateUtil(currentDate);

        if (dateUtil.isNight()) {
            List<Employee> employees = employeeService.getAll();

            for (Employee employee : employees) {
                punishEmployeeIfNeeded(employee);
            }
        }
    }

    private void punishEmployeeIfNeeded(Employee employee) {
        List<VoucherDto> voucherDtoList = voucherRepository.getVoucherDtoList(employee.getId());

        if (voucherDtoList != null && voucherDtoList.size() > 0) {
            VoucherDto lastVoucherDto = voucherDtoList.get(0);

            if (lastVoucherDto.getType().equals(ConfigManager.getVoucherTypeIn())) {
                System.out.println(employee.getName() + " forgot to Vouch OUT. We are punishing him/her!");

                Date outDate = DateUtil.getHoursAhead(
                        lastVoucherDto.getActualDate(), ConfigManager.getVoucherNoOutPunishment());
                add(lastVoucherDto.getActualDate(), outDate, ConfigManager.getVoucherTypeOut(),
                        lastVoucherDto.getLocation(), employee);
            }
        }
    }

    private void add(Date actualInDate, Date outDate, String type, String location, Employee employee) {
        Voucher voucher = new Voucher();
        DateUtil outDateUtil = new DateUtil(outDate);

        setProperties(voucher, type, location, true, employee);
        setDates(voucher, outDateUtil);

        workInfoService.addHours(actualInDate, outDateUtil.getActualDate(), location, employee);
        voucherRepository.save(voucher);
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
        if (dateUtil.isNight())
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
