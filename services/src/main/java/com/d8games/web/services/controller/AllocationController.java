package com.d8games.web.services.controller;

import com.d8games.web.services.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allocation")
public class AllocationController {

    @Autowired
    AllocationRepository allocationRepository;

}
