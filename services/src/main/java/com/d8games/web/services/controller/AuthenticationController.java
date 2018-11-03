package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Authentication;
import com.d8games.web.services.service.AuthenticationService;
import com.d8games.web.services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/services/controller/authentication")
@SuppressWarnings("unused")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/getAll")
    public List<Authentication> getAll() {
        return authenticationService.getAll();
    }

    @GetMapping(value = "/getById")
    public Authentication getById(@RequestParam String id) {
        return authenticationService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String authenticationIp) {
        Authentication authentication = new Authentication();

        authentication.setAuthenticationIp(authenticationIp);
        authentication.setAuthenticationCreatedDate(new Date());

        authenticationService.save(authentication);
        return authentication.getAuthenticationId();
    }

    @PostMapping(value = "/update")
    public HttpStatus update(@RequestParam String authenticationId, @RequestParam String authenticationEmployeeId) {
        Authentication authentication = authenticationService.getById(authenticationId);
        authentication.setAuthenticationEmployee(employeeService.getById(authenticationEmployeeId));

        authenticationService.save(authentication);
        return HttpStatus.OK;
    }
}
