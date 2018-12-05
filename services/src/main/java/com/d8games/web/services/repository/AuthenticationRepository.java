package com.d8games.web.services.repository;

import com.d8games.web.services.model.dto.AuthenticationDto;
import com.d8games.web.services.model.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {

    Authentication getAuthenticationById(String id);

    @Query(
    "SELECT a " +
    "FROM Authentication a " +
    "INNER JOIN Employee e ON a.mobilePhoneId = e.mobilePhoneId " +
    "WHERE e.id = :employeeId " +
    "ORDER BY a.createdDate DESC"
    )
    List<Authentication> getAuthenticationListByEmployeeId(@Param("employeeId") String employeeId);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.AuthenticationDto(a.mobilePhoneId, a.ip) " +
    "FROM Authentication a " +
    "WHERE id = :authenticationId")
    AuthenticationDto getAuthenticationDto(@Param("authenticationId") String authenticationId);
}
