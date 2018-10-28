package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Department getDepartmentByDepartmentId(String departmentId);

    @Query(
    "SELECT d.departmentName " +
    "FROM Department d")
    List<String> getAllDepartmentNames();
}
