package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Department;
import com.d8games.web.services.service.DepartmentService;
import com.d8games.web.services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/department")
@SuppressWarnings("unused")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAll")
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping(value = "/getById")
    public Department getById(@RequestParam String id) {
        return departmentService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String departmentName, @RequestParam String departmentManagerId,
                       @RequestParam Integer departmentRank) {
        Department department = new Department();

        department.setDepartmentName(departmentName);
        department.setDepartmentManager(employeeService.getById(departmentManagerId));
        department.setDepartmentRank(departmentRank);

        departmentService.save(department);
        return department.getDepartmentId();
    }

    @GetMapping(value="/departmentName/getAll")
    public List<String> getAllDepartmentNames() {
        return departmentService.getAllDepartmentNames();
    }
}
