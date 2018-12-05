package com.d8games.web.services.controller;

import com.d8games.web.services.exception.EmployeeNotAuthorizedException;
import com.d8games.web.services.model.dto.AuthenticatedEmployeeDto;
import com.d8games.web.services.model.entity.Authentication;
import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
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
    public void update(@RequestParam String id, @RequestParam String ip, @RequestParam String mobilePhoneId) {
        authenticationService.update(id, ip, mobilePhoneId);
    }

    @PutMapping(value = "/save")
    public HttpStatus save() {
        authenticationService.save();
        return HttpStatus.OK;
    }

    @PutMapping(value = "/requestAuth")
    public String requestAuth(@RequestParam String employeeId) throws IOException, MessagingException {
        Employee requestEmployee = authenticationService.requestAuth(employeeId);
        return requestEmployee.getName();
    }

    @GetMapping(value = "/authenticate")
    public HttpStatus authenticate(@RequestParam String employeeId, @RequestParam String authKey)
            throws EmployeeNotAuthorizedException {
        Authentication lastAuthentication = authenticationService.getLastAuthenticationByEmployeeId(employeeId);

        if (lastAuthentication.getId().equals(authKey))
            return HttpStatus.OK;

        throw new EmployeeNotAuthorizedException(employeeId);
    }

    @GetMapping(value = "/authenticatedEmployee")
    public AuthenticatedEmployeeDto getAuthenticatedEmployeeDto(@RequestParam String authenticationId) throws TimeoutException {
        return authenticationService.getAuthenticatedEmployeeDto(authenticationId);
    }
}
