package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Allocation;
import com.d8games.web.services.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    @Autowired
    AllocationRepository allocationRepository;

    public List<Allocation> getAll() {
        return allocationRepository.findAll();
    }

    public Allocation getById(String id) {
        return allocationRepository.getAllocationByAllocationId(id);
    }

    public void save(Allocation allocation) {
        allocationRepository.save(allocation);
    }
}
