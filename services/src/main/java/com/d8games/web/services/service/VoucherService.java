package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAll() {
        return voucherRepository.findAll();
    }

    public Voucher getById(String id) {
        return voucherRepository.getVoucherById(id);
    }

    public void save(Voucher voucher) {
        voucherRepository.save(voucher);
    }
}
