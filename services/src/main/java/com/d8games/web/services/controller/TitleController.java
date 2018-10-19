package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Department;
import com.d8games.web.services.model.entity.Title;
import com.d8games.web.services.repository.DepartmentRepository;
import com.d8games.web.services.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    TitleRepository titleRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = "/getAll")
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    @PutMapping(value = "/addTitle/values")
    public HttpStatus addTitle(@RequestParam String name, @RequestParam Double officeHoursNeededPerMonth,
                               @RequestParam Double homeHoursNeededPerMonth, @RequestParam Double salaryPerHour,
                               @RequestParam Double overtimeSalaryPerHour, @RequestParam String departmentId) {
        Title title = new Title();

        title.setName(name);
        title.setOfficeHoursNeededPerMonth(officeHoursNeededPerMonth);
        title.setHomeHoursNeededPerMonth(homeHoursNeededPerMonth);
        title.setSalaryPerHour(salaryPerHour);
        title.setOvertimeSalaryPerHour(overtimeSalaryPerHour);

        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        optionalDepartment.ifPresent(department -> title.setDepartment(department));

        titleRepository.save(title);
        return HttpStatus.OK;
    }
}
