package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, String> {

    JobInfo getJobInfoById(String id);

    @Query(
    "SELECT jobInfo " +
    "FROM JobInfo jobInfo " +
    "INNER JOIN Title title ON title.jobInfo = jobInfo " +
    "INNER JOIN Employee employee ON employee.title = title " +
    "WHERE employee = :employee")
    JobInfo getJobInfoByEmployee(@Param("employee") Employee employee);
}
