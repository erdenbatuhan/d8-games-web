package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.JobInfo;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/jobInfo")
public class JobInfoController {

    @Autowired
    private JobInfoService jobInfoService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<JobInfo> getAll() {
        return jobInfoService.getAll();
    }

    @GetMapping(value = "/get")
    public JobInfo getById(@RequestParam String id) {
        return jobInfoService.getById(id);
    }

    @GetMapping(value = "/getByEmployee")
    public JobInfo getByEmployee(@RequestParam String employeeId) {
        Employee employee = employeeService.getById(employeeId);
        return jobInfoService.getByEmployee(employee);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String name,
                       @RequestParam double unpaidHoursNeededPerMonth, @RequestParam double officeHoursNeededPerMonth,
                       @RequestParam double homeHoursNeededPerMonth, @RequestParam double excusedHoursAllowedPerMonth,
                       @RequestParam double salaryPerHour, @RequestParam double overtimeSalaryPerHour) {
        JobInfo jobInfo = new JobInfo();

        jobInfo.setName(name);
        jobInfo.setUnpaidHoursNeededPerMonth(unpaidHoursNeededPerMonth);
        jobInfo.setOfficeHoursNeededPerMonth(officeHoursNeededPerMonth);
        jobInfo.setHomeHoursNeededPerMonth(homeHoursNeededPerMonth);
        jobInfo.setExcusedHoursAllowedPerMonth(excusedHoursAllowedPerMonth);
        jobInfo.setSalaryPerHour(salaryPerHour);
        jobInfo.setOvertimeSalaryPerHour(overtimeSalaryPerHour);

        jobInfoService.save(jobInfo);
        return jobInfo.getId();
    }
}
