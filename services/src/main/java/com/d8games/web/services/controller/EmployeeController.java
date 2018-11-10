package com.d8games.web.services.controller;

import com.d8games.web.services.exception.EmployeeNotFound;
import com.d8games.web.services.model.dto.ContactCardDto;
import com.d8games.web.services.model.dto.DashboardCardDto;
import com.d8games.web.services.model.dto.EmployeeCardDto;
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

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(value = "/get")
    public Employee getById(@RequestParam String id) {
        return employeeService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String mobilePhoneId, @RequestParam String name, @RequestParam String surname,
                       @RequestParam String email, @RequestParam String phoneNumber, @RequestParam String titleId) {
        Employee employee = new Employee();

        employee.setMobilePhoneId(mobilePhoneId);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setCompletedStoryPoints(0.0);
        employee.setJoinDate(new Date()); // Get the current date
        employee.setTitle(titleService.getById(titleId));

        employeeService.save(employee);
        return employee.getId();
    }

    @GetMapping(value = "/dashboardCardDtoList")
    public List<DashboardCardDto> getDashboardCardDtoList() {
        return employeeService.getDashboardCardDtoList();
    }

    @GetMapping(value = "/contactCardDtoList")
    public List<ContactCardDto> getContactCardDtoList() {
        return employeeService.getContactCardDtoList();
    }

    @GetMapping(value = "/employeeCardDto")
    public EmployeeCardDto getEmployeeCardDto(@RequestParam String employeeId) throws EmployeeNotFound {
        EmployeeCardDto employeeCardDto = employeeService.getEmployeeCardDto(employeeId);

        if (employeeCardDto == null) {
            throw new EmployeeNotFound(employeeId);
        } else {
            String managerId = employeeCardDto.getManagerId();
            String managerFullName = employeeService.getEmployeeFullNameById(managerId);

            employeeCardDto.setManagerFullName(managerFullName);
        }

        return employeeCardDto;
    }

    @PostMapping(value = "/addStoryPoints")
    public HttpStatus addStoryPoints(@RequestParam String employeeId, @RequestParam double storyPointsToAdd) {
        Employee employee = employeeService.getById(employeeId);

        double completedStoryPoints = employee.getCompletedStoryPoints();
        employee.setCompletedStoryPoints(completedStoryPoints + storyPointsToAdd);

        employeeService.save(employee);
        return HttpStatus.OK;
    }
}
