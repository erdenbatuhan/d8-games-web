package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Department;
import com.d8games.web.services.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentByDepartmentId(String departmentId) {
        return departmentRepository.getDepartmentByDepartmentId(departmentId);
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }
}
