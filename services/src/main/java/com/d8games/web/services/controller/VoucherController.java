package com.d8games.web.services.controller;

import com.d8games.web.services.model.dto.VoucherItemDto;
import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/voucher")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping
    public List<Voucher> getAllByEmployeeId(@RequestParam String employeeId) {
        return voucherService.getAllByEmployeeId(employeeId);
    }

    @GetMapping(value = "/get")
    public Voucher getById(@RequestParam String id) {
        return voucherService.getById(id);
    }

    @PutMapping(value = "/add")
    public String add(@RequestParam String type, @RequestParam String ip, @RequestParam String employeeId) {
        return voucherService.add(type, ip, employeeId);
    }

    @GetMapping(value = "/voucherItemDtoList")
    public List<VoucherItemDto> getVoucherItemDtoList(@RequestParam String employeeId) {
        return voucherService.getVoucherItemDtoList(employeeId);
    }
}
