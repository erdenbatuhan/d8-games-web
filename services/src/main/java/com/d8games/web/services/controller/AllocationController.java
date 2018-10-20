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
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value="/getAll")
    public List<Allocation> getAllAllocations() {
        return allocationService.getAllAllocations();
    }

    @PutMapping(value = "/save")
    public HttpStatus saveAllocation(@RequestParam Date allocationDate, @RequestParam String allocationType,
                                     @RequestParam String allocationEmployeeId) {
        Allocation allocation = new Allocation();

        allocation.setAllocationDate(allocationDate);
        allocation.setAllocationType(allocationType);
        allocation.setAllocationEmployee(employeeService.getEmployeeByEmployeeId(allocationEmployeeId));

        allocationService.saveAllocation(allocation);
        return HttpStatus.OK;
    }

}
