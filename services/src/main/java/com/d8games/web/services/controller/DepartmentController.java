package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Department;
import com.d8games.web.services.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value="/getAll")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PutMapping(value = "/addDepartment/values")
    public HttpStatus addDepartment(@RequestParam String name) {
        Department department = new Department();

        department.setName(name);
        departmentRepository.save(department);

        return HttpStatus.OK;
    }
}
