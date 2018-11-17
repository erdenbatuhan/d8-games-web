package com.d8games.web.services.controller;

import com.d8games.web.services.model.dto.AuthenticatedEmployeeDto;
import com.d8games.web.services.model.dto.AuthenticationDto;
import com.d8games.web.services.model.entity.Authentication;
import com.d8games.web.services.service.AuthenticationService;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.config.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/api/services/controller/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public List<Authentication> getAll() {
        return authenticationService.getAll();
    }

    @GetMapping(value = "/get")
    public Authentication getById(@RequestParam String id) {
        return authenticationService.getById(id);
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam String id, @RequestParam String ip, @RequestParam String mobilePhoneId) {
        return authenticationService.update(id, ip, mobilePhoneId);
    }

    @PutMapping(value = "/save")
    public String save() {
        return authenticationService.save();
    }

    @GetMapping(value = "/authenticatedEmployee")
    public AuthenticatedEmployeeDto getAuthenticatedEmployeeDto(@RequestParam String authenticationId) throws TimeoutException {
        return authenticationService.getAuthenticatedEmployeeDto(authenticationId);
    }
}
