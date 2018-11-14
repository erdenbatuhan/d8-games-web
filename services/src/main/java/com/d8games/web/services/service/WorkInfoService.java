package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.WorkInfo;
import com.d8games.web.services.repository.WorkInfoRepository;
import com.d8games.web.services.util.DateUtil;
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
    private EmployeeService employeeService;

    public List<WorkInfo> getAll() {
        return workInfoRepository.findAll();
    }

    public WorkInfo getById(String id) {
        return workInfoRepository.getWorkInfoById(id);
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
        add(0.0, 0.0, employee);
    }

    public List<String> add(double officeHoursWorked, double homeHoursWorked, Employee employee) {
        List<String> workInfoIdList = new ArrayList<>();
        Date currentDate = new Date();

        for (int i = 0; i < 4; i++) {
            WorkInfo workInfo = new WorkInfo();
            Date sixDaysAhead = DateUtil.getDaysAhead(currentDate, 6);

            setDates(workInfo, currentDate, sixDaysAhead);

            workInfo.setOfficeHoursWorked(officeHoursWorked);
            workInfo.setHomeHoursWorked(homeHoursWorked);
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
}
