package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.WorkInfo;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.service.WorkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/workInfo")
public class WorkInfoController {

    @Autowired
    private WorkInfoService workInfoService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<WorkInfo> getAll() {
        return workInfoService.getAll();
    }

    @GetMapping(value = "/get")
    public WorkInfo getById(@RequestParam String id) {
        return workInfoService.getById(id);
    }

    @PutMapping(value = "/add")
    public List<String> add(@RequestParam double officeHoursWorked, @RequestParam double homeHoursWorked,
                            @RequestParam String employeeId) {
        return workInfoService.add(officeHoursWorked, homeHoursWorked, employeeService.getById(employeeId));
    }
}
