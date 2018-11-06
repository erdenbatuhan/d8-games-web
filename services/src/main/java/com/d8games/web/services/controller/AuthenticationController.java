package com.d8games.web.services.controller;

import com.d8games.web.services.model.dto.AuthenticatedDto;
import com.d8games.web.services.model.dto.AuthenticationDto;
import com.d8games.web.services.model.entity.Authentication;
import com.d8games.web.services.service.AuthenticationService;
import com.d8games.web.services.service.EmployeeService;
import com.d8games.web.services.config.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(ConfigManager.getOfficeIp());
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
    public AuthenticatedDto getAuthenticated(@RequestParam String authenticationId) {
        long start = System.currentTimeMillis();

        AuthenticatedDto authenticatedDto = new AuthenticatedDto();
        AuthenticationDto authenticationDto = null;

        String authenticationEmployeeMobilePhoneId = null;

        while (authenticationEmployeeMobilePhoneId == null) {
            authenticationDto = authenticationService.getAuthenticationDto(authenticationId);
            authenticationEmployeeMobilePhoneId = authenticationDto.getAuthenticationEmployeeMobilePhoneId();

            long timeElapsed = System.currentTimeMillis() - start;
            if (timeElapsed >= ConfigManager.getAuthenticationTimeout())
                return authenticatedDto;
        }

        String authenticatedEmployeeId = employeeService.
                getEmployeeIdByEmployeeMobilePhoneId(authenticationEmployeeMobilePhoneId);
        String authenticatedEmployeeIp = authenticationDto.getAuthenticationIp();

        return new AuthenticatedDto(authenticatedEmployeeId, authenticatedEmployeeIp);
    }
}
