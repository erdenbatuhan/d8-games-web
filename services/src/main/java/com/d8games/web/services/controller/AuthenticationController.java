package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Authentication;
import com.d8games.web.services.service.AuthenticationService;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.util.ProjectConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
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
    public String save() {
        Authentication authentication = new Authentication();
        authentication.setAuthenticationCreatedDate(new Date());

        authenticationService.save(authentication);
        return authentication.getAuthenticationId();
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam String authenticationId, @RequestParam String authenticationIp,
                         @RequestParam String authenticationEmployeeMobilePhoneId) {
        Authentication authentication = authenticationService.getById(authenticationId);

        authentication.setAuthenticationIp(authenticationIp);
        authentication.setAuthenticationEmployeeMobilePhoneId(authenticationEmployeeMobilePhoneId);

        authenticationService.save(authentication);
        return authenticationId;
    }

    @GetMapping(value = "/getAuthenticated")
    public String getAuthenticated(@RequestParam String authenticationId) {
        long start = System.currentTimeMillis();
        String authenticationEmployeeMobilePhoneId = null;

        while (authenticationEmployeeMobilePhoneId == null) {
            authenticationEmployeeMobilePhoneId = authenticationService.
                    getAuthenticationEmployeeMobilePhoneIdByAuthenticationId(authenticationId);

            long timeElapsed = System.currentTimeMillis() - start;
            if (timeElapsed >= ProjectConstants.AUTHENTICATION_TIMEOUT)
                return null;
        }

        return employeeService.getEmployeeIdByEmployeeMobilePhoneId(authenticationEmployeeMobilePhoneId);
    }
}
