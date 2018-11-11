package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.WorkInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkInfoRepository extends JpaRepository<WorkInfo, String> {

    WorkInfo getWorkInfoById(String id);

    @Query(
    "SELECT w.actualEndDate " +
    "FROM WorkInfo w " +
    "ORDER BY w.actualEndDate DESC")
    List<Date> getActualEndDates();
}
