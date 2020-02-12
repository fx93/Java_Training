package com.fx.allocation.service;

import com.fx.allocation.model.Allocation;
import com.fx.allocation.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService{

    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation createAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    @Override
    public List<Allocation> fetchAllAllocation() {
        return allocationRepository.findAll();
    }

    @Override
    public Optional<Allocation> getAllocationById(Integer id) {
        return allocationRepository.findById(id);
    }
}
