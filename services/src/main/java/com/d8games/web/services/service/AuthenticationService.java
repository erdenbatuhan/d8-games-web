package com.d8games.web.services.service;

import com.d8games.web.services.model.dto.AuthenticationDto;
import com.d8games.web.services.model.entity.Authentication;
import com.d8games.web.services.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationRepository authenticationRepository;

    public List<Authentication> getAll() {
        return authenticationRepository.findAll();
    }

    public Authentication getById(String id) {
        return authenticationRepository.getAuthenticationByAuthenticationId(id);
    }

    public void save(Authentication authentication) {
        authenticationRepository.save(authentication);
    }

    public AuthenticationDto getAuthenticationDto(String authenticationId) {
        return authenticationRepository.getAuthenticationDto(authenticationId);
    }
}
