package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.JobInfo;
import com.d8games.web.services.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/jobInfo")
@SuppressWarnings("unused")
public class JobInfoController {

    @Autowired
    private JobInfoService jobInfoService;

    @GetMapping
    public List<JobInfo> getAll() {
        return jobInfoService.getAll();
    }

    @GetMapping(value = "/get")
    public JobInfo getById(@RequestParam String id) {
        return jobInfoService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String name, @RequestParam double unpaidHoursNeededPerMonth,
                       @RequestParam double officeHoursNeededPerMonth, @RequestParam double homeHoursNeededPerMonth,
                       @RequestParam double salaryPerHour, @RequestParam double overtimeSalaryPerHour) {
        JobInfo jobInfo = new JobInfo();

        jobInfo.setName(name);
        jobInfo.setUnpaidHoursNeededPerMonth(unpaidHoursNeededPerMonth);
        jobInfo.setOfficeHoursNeededPerMonth(officeHoursNeededPerMonth);
        jobInfo.setHomeHoursNeededPerMonth(homeHoursNeededPerMonth);
        jobInfo.setSalaryPerHour(salaryPerHour);
        jobInfo.setOvertimeSalaryPerHour(overtimeSalaryPerHour);

        jobInfoService.save(jobInfo);
        return jobInfo.getId();
    }
}
