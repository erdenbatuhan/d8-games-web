package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {

    Authentication getAuthenticationByAuthenticationId(String authenticationId);
}
