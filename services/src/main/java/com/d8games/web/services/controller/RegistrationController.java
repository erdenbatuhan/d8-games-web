package com.d8games.web.services.controller;

import com.d8games.web.services.model.Department;
import com.d8games.web.services.model.Title;
import com.d8games.web.services.model.User;
import com.d8games.web.services.repository.DepartmentRepository;
import com.d8games.web.services.repository.TitleRepository;
import com.d8games.web.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TitleRepository titleRepository;

    @PutMapping(value = "/department/addDepartment/values")
    public HttpStatus addDepartment(@RequestParam String name) {
        Department department = new Department();
        department.setName(name);

        departmentRepository.save(department);
        return HttpStatus.OK;
    }

    @GetMapping(value="/department/getAll")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PutMapping(value = "/title/addTitle/values")
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

    @GetMapping(value = "/title/getAll")
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    @PutMapping(value = "/user/addUser/values")
    public HttpStatus addUser(@RequestParam String name, @RequestParam String surname,
                              @RequestParam String photo, @RequestParam String titleId) {
        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPhoto(photo);
        user.setStartingDate(new Date());

        Optional<Title> optionalTitle = titleRepository.findById(titleId);
        optionalTitle.ifPresent(title -> user.setTitle(title));

        userRepository.save(user);
        return HttpStatus.OK;
    }

    @GetMapping(value="/user/getAll")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
