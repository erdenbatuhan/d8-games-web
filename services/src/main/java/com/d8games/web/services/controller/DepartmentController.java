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
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAll")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping(value = "/save")
    public HttpStatus saveDepartment(@RequestParam String departmentName, @RequestParam String departmentManagerId) {
        Department department = new Department();

        department.setDepartmentName(departmentName);
        department.setDepartmentManager(employeeService.getEmployeeByEmployeeId(departmentManagerId));

        departmentService.saveDepartment(department);
        return HttpStatus.OK;
    }
}
