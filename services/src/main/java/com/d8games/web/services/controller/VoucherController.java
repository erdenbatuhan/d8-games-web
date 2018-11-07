package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.service.VoucherService;
import com.d8games.web.services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/services/controller/voucher")
@SuppressWarnings("unused")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Voucher> getAll() {
        return voucherService.getAll();
    }

    @GetMapping(value = "/get")
    public Voucher getById(@RequestParam String id) {
        return voucherService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String type, @RequestParam String employeeId) {
        Voucher voucher = new Voucher();

        voucher.setType(type);
        voucher.setActualDate(new Date());
        voucher.setEmployee(employeeService.getById(employeeId));

        voucherService.save(voucher);
        return voucher.getId();
    }
}
