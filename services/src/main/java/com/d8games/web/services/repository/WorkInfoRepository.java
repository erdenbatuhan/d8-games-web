package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkInfoRepository extends JpaRepository<WorkInfo, String> {

    WorkInfo getWorkInfoByWorkInfoId(String workInfoId);
}
