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

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(String id) {
        return departmentRepository.getDepartmentByDepartmentId(id);
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public List<String> getAllDepartmentNames() {
        return departmentRepository.getAllDepartmentNames();
    }
}
