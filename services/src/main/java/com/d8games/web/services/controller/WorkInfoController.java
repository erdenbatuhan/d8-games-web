package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.WorkInfo;
import com.d8games.web.services.service.WorkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/workInfo")
public class WorkInfoController {

    @Autowired
    WorkInfoService workInfoService;

    @GetMapping(value = "/getAll")
    public List<WorkInfo> getAllWorkInfo() {
        return workInfoService.getAllWorkInfo();
    }

    @GetMapping(value = "/getById")
    public WorkInfo getById(@RequestParam String id) {
        return workInfoService.getById(id);
    }

    @PutMapping(value = "/save")
    public HttpStatus saveWorkInfo(@RequestParam String workInfoName, @RequestParam double officeHoursNeededPerMonth,
                                   @RequestParam double homeHoursNeededPerMonth,
                                   @RequestParam double unpaidHoursNeededPerMonth,
                                   @RequestParam double salaryPerHour, @RequestParam double overtimeSalaryPerHour) {
        WorkInfo workInfo = new WorkInfo();

        workInfo.setWorkInfoName(workInfoName);
        workInfo.setOfficeHoursNeededPerMonth(officeHoursNeededPerMonth);
        workInfo.setHomeHoursNeededPerMonth(homeHoursNeededPerMonth);
        workInfo.setUnpaidHoursNeededPerMonth(unpaidHoursNeededPerMonth);
        workInfo.setSalaryPerHour(salaryPerHour);
        workInfo.setOvertimeSalaryPerHour(overtimeSalaryPerHour);

        workInfoService.saveWorkInfo(workInfo);
        return HttpStatus.OK;
    }
}
