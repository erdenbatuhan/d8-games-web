package com.d8games.web.services.repository;

import com.d8games.web.services.model.dto.DashboardCardDto;
import com.d8games.web.services.model.dto.EmployeeCardDto;
import com.d8games.web.services.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee getEmployeeByEmployeeId(String employeeId);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.DashboardCardDto(" +
            "e.employeeId, e.employeeName, e.employeeSurname, t.titleName, d.departmentName) " +
    "FROM Employee e " +
    "INNER JOIN Title t ON e.employeeTitle = t " +
    "INNER JOIN Department d ON t.titleDepartment = d")
    List<DashboardCardDto> getDashboardCardDtoList();

    @Query(
    "SELECT new com.d8games.web.services.model.dto.EmployeeCardDto(" +
            "e.employeeName, e.employeeSurname, t.titleName, d.departmentName, e.employeeJoinDate) " +
    "FROM Employee e " +
    "INNER JOIN Title t ON e.employeeTitle = t " +
    "INNER JOIN Department d ON t.titleDepartment = d " +
    "WHERE e.employeeId = :employeeId")
    EmployeeCardDto getEmployeeCardDto(@Param("employeeId") String employeeId);
}
