package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, String> {

    Voucher getVoucherById(String id);
}
