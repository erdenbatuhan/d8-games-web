package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {

    Authentication getAuthenticationByAuthenticationId(String authenticationId);

    @Query(
    "SELECT a.authenticationEmployeeMobilePhoneId " +
    "FROM Authentication a " +
    "WHERE a.authenticationId = :authenticationId")
    String getAuthenticationEmployeeMobilePhoneIdByAuthenticationId(@Param("authenticationId") String authenticationId);
}
