package com.d8games.web.services.service;

import com.d8games.web.services.config.ConfigManager;
import com.d8games.web.services.model.dto.MonthlySummaryDto;
import com.d8games.web.services.model.dto.WeeklySummaryDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.JobInfo;
import com.d8games.web.services.model.entity.WorkInfo;
import com.d8games.web.services.repository.WorkInfoRepository;
import com.d8games.web.services.util.DateUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkInfoService {

    @Autowired
    private WorkInfoRepository workInfoRepository;

    @Autowired
    private JobInfoService jobInfoService;

    @Autowired
    private EmployeeService employeeService;

    public List<WorkInfo> getAll() {
        return workInfoRepository.findAll();
    }

    public WorkInfo getById(String id) {
        return workInfoRepository.getWorkInfoById(id);
    }

    public WeeklySummaryDto getWeeklySummaryDto(String employeeId) {
        return workInfoRepository.getWeeklySummaryDto(new Date(), employeeId);
    }

    public MonthlySummaryDto getMonthlySummaryDto(String employeeId) {
        List<WeeklySummaryDto> weeklySummaryDtoList = workInfoRepository.getWeeklySummaryDtoList(employeeId).subList(0, 4);
        return new MonthlySummaryDto(weeklySummaryDtoList);
    }

    @Scheduled(fixedRate = 7200000)
    public void addDatesWhenNotPresent() {
        List<Date> actualEndDates = workInfoRepository.getActualEndDates();

        if (actualEndDates.size() == 0)
            return;

        Date currentDate = new Date();
        Date latestEndDate = actualEndDates.get(0);

        if (currentDate.compareTo(latestEndDate) > 0) { // Current Date is after Latest End Date
            System.out.println("Adding each week of the current month...");
            List<Employee> employees = employeeService.getAll();

            for (Employee employee : employees)
                add(employee);
        }
    }

    private void add(Employee employee) {
        JobInfo jobInfo = jobInfoService.getByEmployee(employee);

        double unpaidHoursNeededPerWeek = jobInfo.getUnpaidHoursNeededPerMonth() / 4;
        double initialOfficeHoursCompleted = 0 - unpaidHoursNeededPerWeek;

        add(initialOfficeHoursCompleted, 0.0, 0.0, employee);
    }

    public List<String> add(double officeHoursCompleted, double homeHoursCompleted, double excusedHoursUsed, Employee employee) {
        List<String> workInfoIdList = new ArrayList<>();
        Date currentDate = new Date();

        for (int i = 0; i < 4; i++) {
            WorkInfo workInfo = new WorkInfo();
            Date sixDaysAhead = DateUtil.getDaysAhead(currentDate, 6);

            setDates(workInfo, currentDate, sixDaysAhead);

            workInfo.setOfficeHoursCompleted(officeHoursCompleted);
            workInfo.setHomeHoursCompleted(homeHoursCompleted);
            workInfo.setExcusedHoursUsed(excusedHoursUsed);
            workInfo.setEmployee(employee);

            workInfoIdList.add(workInfo.getId());
            currentDate = DateUtil.getDaysAhead(sixDaysAhead, 1);

            workInfoRepository.save(workInfo);
        }

        return workInfoIdList;
    }

    private void setDates(WorkInfo workInfo, Date currentDate, Date sixDaysAhead) {
        DateUtil startDateUtil = new DateUtil(currentDate);
        DateUtil endDateUtil = new DateUtil(sixDaysAhead);

        Date actualStartDate = startDateUtil.getActualDate();
        Date actualEndDate = endDateUtil.getActualDate();

        String startDate = startDateUtil.getDate();
        String endDate = endDateUtil.getDate();

        workInfo.setActualStartDate(actualStartDate);
        workInfo.setActualEndDate(actualEndDate);

        workInfo.setStartDate(startDate);
        workInfo.setEndDate(endDate);
    }

    public void addHours(Date vouchInDate, Date vouchOutDate, String location, Employee employee) {
        JobInfo jobInfo = jobInfoService.getByEmployee(employee);
        WorkInfo workInfo = workInfoRepository.getCurrentWorkInfo(vouchOutDate, employee);

        DateTime vouchInDateTime = new DateTime(vouchInDate);
        DateTime vouchOutDateTime = new DateTime(vouchOutDate);

        int vouchInDateInt = DateUtil.getIntegerDate(vouchInDateTime);
        int vouchOutDateInt = DateUtil.getIntegerDate(vouchOutDateTime);

        double hoursWorked = DateUtil.getDiff(vouchInDateInt, vouchOutDateInt);

        if (location.equals(ConfigManager.getVoucherLocationOffice())) {
            setOfficeHoursCompleted(workInfo, hoursWorked);
        } else {
            setHomeHoursCompleted(jobInfo, workInfo, hoursWorked);
        }

        workInfoRepository.save(workInfo);
    }

    private void setOfficeHoursCompleted(WorkInfo workInfo, double hoursWorked) {
        double officeHoursCompleted = workInfo.getOfficeHoursCompleted() + hoursWorked;
        workInfo.setOfficeHoursCompleted(officeHoursCompleted);
    }

    private void setHomeHoursCompleted(JobInfo jobInfo, WorkInfo workInfo, double hoursWorked) {
        double homeHoursNeededPerWeek = jobInfo.getHomeHoursNeededPerMonth() / 4;
        double homeHoursCompleted = workInfo.getHomeHoursCompleted() + hoursWorked;

        if (homeHoursCompleted > homeHoursNeededPerWeek)
            homeHoursCompleted = homeHoursNeededPerWeek;

        workInfo.setHomeHoursCompleted(homeHoursCompleted);
    }
}
