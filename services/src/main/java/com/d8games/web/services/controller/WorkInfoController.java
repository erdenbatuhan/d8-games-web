package com.d8games.web.services.controller;

import com.d8games.web.services.model.dto.MonthlySummaryDto;
import com.d8games.web.services.model.dto.WeeklySummaryDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.WorkInfo;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.service.WorkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public List<String> add(@RequestParam double officeHoursCompleted, @RequestParam double homeHoursCompleted,
                            @RequestParam double excusedHoursUsed, @RequestParam String employeeId) {
        Employee employee = employeeService.getById(employeeId);
        return workInfoService.add(new Date(), officeHoursCompleted, homeHoursCompleted, excusedHoursUsed, employee);
    }

    @GetMapping(value = "/weekly")
    public WeeklySummaryDto getWeeklySummaryDto(@RequestParam String employeeId) {
        return workInfoService.getWeeklySummaryDto(employeeId);
    }

    @GetMapping(value = "/monthly")
    public MonthlySummaryDto getMonthlySummaryDto(@RequestParam String employeeId) {
        return workInfoService.getMonthlySummaryDto(employeeId);
    }
}
