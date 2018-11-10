package com.d8games.web.services.repository;

import com.d8games.web.services.model.dto.ContactCardDto;
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

    Employee getEmployeeById(String id);

    @Query(
    "SELECT concat(e.name, ' ', e.surname) " +
    "FROM Employee e " +
    "WHERE e.id = :employeeId")
    String getEmployeeFullNameById(@Param("employeeId") String employeeId);

    Employee getEmployeeByMobilePhoneId(String mobilePhoneId);

    @Query(
    "SELECT e.id " +
    "FROM Employee e " +
    "WHERE e.mobilePhoneId = :mobilePhoneId")
    String getEmployeeIdByMobilePhoneId(@Param("mobilePhoneId") String mobilePhoneId);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.DashboardCardDto(" +
            "e.id, concat(e.name, ' ', e.surname), t.name, d.name) " +
    "FROM Employee e " +
    "INNER JOIN Title t ON e.title = t " +
    "INNER JOIN Department d ON t.department = d " +
    "ORDER BY d.rank")
    List<DashboardCardDto> getDashboardCardDtoList();

    @Query(
    "SELECT new com.d8games.web.services.model.dto.ContactCardDto(" +
        "concat(e.name, ' ', e.surname), e.email, e.phoneNumber, t.name) " +
    "FROM Employee e " +
    "INNER JOIN Title t ON e.title = t " +
    "INNER JOIN Department d ON t.department = d " +
    "WHERE d.name = :contactDepartmentName " +
    "ORDER BY t.name")
    List<ContactCardDto> getContactCardDtoList(@Param("contactDepartmentName") String contactDepartmentName);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.EmployeeCardDto(" +
            "concat(e.name, ' ', e.surname), t.name, d.name, d.manager.id, " +
            "e.email, e.phoneNumber, e.completedStoryPoints, e.joinDate) " +
    "FROM Employee e " +
    "INNER JOIN Title t ON e.title = t " +
    "INNER JOIN Department d ON t.department = d " +
    "WHERE e.id = :employeeId")
    EmployeeCardDto getEmployeeCardDto(@Param("employeeId") String employeeId);
}

