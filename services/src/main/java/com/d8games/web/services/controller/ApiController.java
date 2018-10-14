package com.d8games.web.services.controller;

import com.d8games.web.services.model.User;
import com.d8games.web.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/users")
    public List<User> getAllUsers() {
        // - This is just for testing.
        // - Normally, we would encapsulate such operations in service classes.
        // - UserService in this case.
        return userRepository.findAll();
    }
}
