package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.MissingVoucherHistory;
import com.d8games.web.services.service.MissingVoucherHistoryService;
import com.d8games.web.services.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/services/controller/missingVoucherHistory")
public class MissingVoucherHistoryController {

    @Autowired
    private MissingVoucherHistoryService missingVoucherHistoryService;

    @Autowired
    private VoucherService voucherService;

    @GetMapping
    public List<MissingVoucherHistory> getAll() {
        return missingVoucherHistoryService.getAll();
    }

    @GetMapping(value = "/get")
    public MissingVoucherHistory getById(@RequestParam String id) {
        return missingVoucherHistoryService.getById(id);
    }

    @PutMapping(value = "/add")
    public String add(@RequestParam String voucherId) {
        return missingVoucherHistoryService.add(voucherService.getById(voucherId));
    }
}
