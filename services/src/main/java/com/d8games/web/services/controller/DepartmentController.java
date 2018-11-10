package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Department;
import com.d8games.web.services.service.DepartmentService;
import com.d8games.web.services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping(value = "/get")
    public Department getById(@RequestParam String id) {
        return departmentService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String name, @RequestParam Integer rank, @RequestParam String managerId) {
        Department department = new Department();

        department.setName(name);
        department.setRank(rank);
        department.setManager(employeeService.getById(managerId));

        departmentService.save(department);
        return department.getId();
    }

    @GetMapping(value="/name")
    public List<String> getAllDepartmentNames() {
        return departmentService.getAllDepartmentNames();
    }
}
