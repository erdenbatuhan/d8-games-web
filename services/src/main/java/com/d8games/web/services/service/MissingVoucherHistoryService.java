package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.MissingVoucherHistory;
import com.d8games.web.services.model.entity.Voucher;
import com.d8games.web.services.repository.MissingVoucherHistoryRepository;
import com.d8games.web.services.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MissingVoucherHistoryService {

    @Autowired
    private MissingVoucherHistoryRepository missingVoucherHistoryRepository;

    @Autowired
    private VoucherService voucherService;

    public List<MissingVoucherHistory> getAll() {
        return missingVoucherHistoryRepository.getAllByOrderByCreatedDateDesc();
    }

    public MissingVoucherHistory getById(String id) {
        return missingVoucherHistoryRepository.getMissingVoucherHistoryById(id);
    }

    public String add(Voucher voucher) {
        MissingVoucherHistory missingVoucherHistory = new MissingVoucherHistory();

        missingVoucherHistory.setCreatedDate(DateUtil.getCurrentDate());
        missingVoucherHistory.setVoucher(voucher);

        missingVoucherHistoryRepository.save(missingVoucherHistory);
        return missingVoucherHistory.getId();
    }
}
