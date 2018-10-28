package com.d8games.web.services.controller;

import com.d8games.web.services.model.dto.DashboardDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/services/controller/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TitleService titleService;

    @GetMapping(value = "/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(value = "/getById")
    public Employee getById(@RequestParam String id) {
        return employeeService.getById(id);
    }

    @PutMapping(value = "/save")
    public HttpStatus save(@RequestParam String employeeName, @RequestParam String employeeSurname,
                           @RequestParam String employeeTitleId) {
        Employee employee = new Employee();

        employee.setEmployeeName(employeeName);
        employee.setEmployeeSurname(employeeSurname);
        employee.setEmployeeJoinDate(new Date()); // Get the current date
        employee.setEmployeeTitle(titleService.getById(employeeTitleId));

        employeeService.save(employee);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/dashboard")
    public List<DashboardDto> getDashboardDtoList() {
        return employeeService.getDashboardDtoList();
    }
}
