package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, String> {

    JobInfo getJobInfoById(String id);
}
