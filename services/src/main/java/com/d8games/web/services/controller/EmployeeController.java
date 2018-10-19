package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.repository.EmployeeRepository;
import com.d8games.web.services.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TitleRepository titleRepository;

    @GetMapping(value="/getAll")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PutMapping(value = "/addEmployee/values")
    public HttpStatus addEmployee(@RequestParam String name, @RequestParam String surname,
                                  @RequestParam String photo, @RequestParam String titleId) {
        Employee employee = new Employee();

        employee.setName(name);
        employee.setSurname(surname);
        employee.setPhoto(photo);
        employee.setStartingDate(new Date());

        Optional<Title> optionalTitle = titleRepository.findById(titleId);
        optionalTitle.ifPresent(title -> employee.setTitle(title));

        employeeRepository.save(employee);
        return HttpStatus.OK;
    }
}
