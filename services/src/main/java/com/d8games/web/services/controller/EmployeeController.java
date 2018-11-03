package com.d8games.web.services.controller;

import com.d8games.web.services.exception.EmployeeNotFound;
import com.d8games.web.services.model.dto.DashboardCardDto;
import com.d8games.web.services.model.dto.EmployeeCardDto;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.service.TitleService;
import com.d8games.web.services.util.ProjectConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/services/controller/employee")
@SuppressWarnings("unused")
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
    public String save(@RequestParam String employeeMobilePhoneId, @RequestParam String employeeName,
                       @RequestParam String employeeSurname, @RequestParam String employeeEmail,
                       @RequestParam String employeePhoneNumber, @RequestParam String employeeJoinDateAsString,
                       @RequestParam String employeeTitleId) throws ParseException {
        Employee employee = new Employee();

        employee.setEmployeeMobilePhoneId(employeeMobilePhoneId);
        employee.setEmployeeName(employeeName);
        employee.setEmployeeSurname(employeeSurname);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeePhoneNumber(employeePhoneNumber);

        Date employeeJoinDate = new Date(); // Get the current date

        if (employeeJoinDateAsString != null)
            employeeJoinDate =  new SimpleDateFormat(ProjectConstants.DATE_FORMAT).parse(employeeJoinDateAsString);

        employee.setEmployeeJoinDate(employeeJoinDate);
        employee.setEmployeeTitle(titleService.getById(employeeTitleId));

        employeeService.save(employee);
        return employee.getEmployeeId();
    }

    @GetMapping(value = "/dashboardCard/getAll")
    public List<DashboardCardDto> getDashboardCardDtoList() {
        return employeeService.getDashboardCardDtoList();
    }

    @GetMapping(value = "/employeeCard")
    public EmployeeCardDto getEmployeeCardDto(@RequestParam String employeeId) throws EmployeeNotFound {
        EmployeeCardDto employeeCardDto = employeeService.getEmployeeCardDto(employeeId);

        if (employeeCardDto == null)
            throw new EmployeeNotFound(employeeId);

        return employeeCardDto;
    }
}
