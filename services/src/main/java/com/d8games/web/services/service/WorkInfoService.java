package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.WorkInfo;
import com.d8games.web.services.repository.WorkInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkInfoService {

    @Autowired
    WorkInfoRepository workInfoRepository;

    public List<WorkInfo> getAll() {
        return workInfoRepository.findAll();
    }

    public WorkInfo getById(String id) {
        return workInfoRepository.getWorkInfoByWorkInfoId(id);
    }

    public void save(WorkInfo workInfo) {
        workInfoRepository.save(workInfo);
    }
}
