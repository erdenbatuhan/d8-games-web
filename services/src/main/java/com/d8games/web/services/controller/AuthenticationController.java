package com.d8games.web.services.controller;

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
        authentication.setEmployee(employeeService.getByMobilePhoneId(mobilePhoneId));

        authenticationService.save(authentication);
        return id;
    }

    @GetMapping(value = "/getDto")
    public AuthenticationDto getAuthenticationDto(@RequestParam String authenticationId) {
        long start = System.currentTimeMillis();

        while (true) {
            AuthenticationDto authenticationDto = authenticationService.getAuthenticationDto(authenticationId);

            long timeElapsed = System.currentTimeMillis() - start;
            if (authenticationDto != null || timeElapsed >= ConfigManager.getAuthenticationTimeout())
                return authenticationDto;
        }
    }
}
