package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Allocation;
import com.d8games.web.services.service.AllocationService;
import com.d8games.web.services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/services/controller/allocation")
@SuppressWarnings("unused")
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAll")
    public List<Allocation> getAll() {
        return allocationService.getAll();
    }

    @GetMapping(value = "/getById")
    public Allocation getById(@RequestParam String id) {
        return allocationService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam Date allocationDate, @RequestParam String allocationType,
                       @RequestParam String allocationEmployeeId) {
        Allocation allocation = new Allocation();

        allocation.setAllocationDate(allocationDate);
        allocation.setAllocationType(allocationType);
        allocation.setAllocationEmployee(employeeService.getById(allocationEmployeeId));

        allocationService.save(allocation);
        return allocation.getAllocationId();
    }
}
