package com.d8games.web.services.repository;

import com.d8games.web.services.model.dto.AuthenticationDto;
import com.d8games.web.services.model.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {

    Authentication getAuthenticationById(String id);

    @Query(
    "SELECT new com.d8games.web.services.model.dto.AuthenticationDto(a.mobilePhoneId, a.ip) " +
    "FROM Authentication a " +
    "WHERE id = :authenticationId")
    AuthenticationDto getAuthenticationDto(@Param("authenticationId") String authenticationId);
}
