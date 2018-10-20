package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee getEmployeeByEmployeeId(String employeeId);
}
