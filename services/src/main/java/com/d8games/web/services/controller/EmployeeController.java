package com.d8games.web.services.controller;

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
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/getById")
    public Employee getEmployeeById(@RequestParam String employeeId) {
        return employeeService.getEmployeeByEmployeeId(employeeId);
    }

    @PutMapping(value = "/save")
    public HttpStatus saveEmployee(@RequestParam String employeeName, @RequestParam String employeeSurname,
                                   @RequestParam String employeePhoto, @RequestParam String employeeTitleId) {
        Employee employee = new Employee();

        employee.setEmployeeName(employeeName);
        employee.setEmployeeSurname(employeeSurname);
        employee.setEmployeePhoto(employeePhoto);
        employee.setEmployeeJoinDate(new Date()); // Get the current date
        employee.setEmployeeTitle(titleService.getTitleByTitleId(employeeTitleId));

        employeeService.saveEmployee(employee);
        return HttpStatus.OK;
    }
}
