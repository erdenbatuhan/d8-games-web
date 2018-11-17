package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.MissingVoucherHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissingVoucherHistoryRepository extends JpaRepository<MissingVoucherHistory, String> {

    List<MissingVoucherHistory> getAllByOrderByCreatedDateDesc();

    MissingVoucherHistory getMissingVoucherHistoryById(String id);
}
