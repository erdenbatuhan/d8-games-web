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

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Authentication> getAll() {
        return authenticationService.getAll();
    }

    @GetMapping(value = "/get")
    public Authentication getById(@RequestParam String id) {
        return authenticationService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save() {
        Authentication authentication = new Authentication();
        authentication.setCreatedDate(new Date());

        authenticationService.save(authentication);
        return authentication.getId();
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam String id, @RequestParam String ip, @RequestParam String mobilePhoneId) {
        Authentication authentication = authenticationService.getById(id);

        authentication.setIp(ip);
        authentication.setMobilePhoneId(mobilePhoneId);

        authenticationService.save(authentication);
        return id;
    }

    @GetMapping(value = "/authenticatedEmployee")
    public AuthenticatedEmployeeDto getAuthenticationDto(@RequestParam String authenticationId) throws TimeoutException {
        int authenticationTimeout = ConfigManager.getAuthenticationTimeout();
        long start = System.currentTimeMillis();

        String mobilePhoneId = null;
        AuthenticationDto authenticationDto = null;

        while (mobilePhoneId == null) {
            long timeElapsed = System.currentTimeMillis() - start;

            authenticationDto = authenticationService.getAuthenticationDto(authenticationId);
            mobilePhoneId = authenticationDto.getMobilePhoneId();

            if (timeElapsed >= authenticationTimeout)
                throw new TimeoutException();
        }

        String employeeId = employeeService.getEmployeeIdByMobilePhoneId(mobilePhoneId);
        String ip = authenticationDto.getIp();


        return new AuthenticatedEmployeeDto(employeeId, ip);
    }
}
