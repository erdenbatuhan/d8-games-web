package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Employee;
import com.d8games.web.services.model.entity.JobInfo;
import com.d8games.web.services.repository.JobInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobInfoService {

    @Autowired
    private JobInfoRepository jobInfoRepository;

    public List<JobInfo> getAll() {
        return jobInfoRepository.findAll();
    }

    public JobInfo getById(String id) {
        return jobInfoRepository.getJobInfoById(id);
    }

    public JobInfo getByEmployee(Employee employee) {
        return jobInfoRepository.getJobInfoByEmployee(employee);
    }

    public void save(JobInfo jobInfo) {
        jobInfoRepository.save(jobInfo);
    }
}
