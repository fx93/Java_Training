package com.fx.allocation.service;

import com.fx.allocation.model.Allocation;

import java.util.List;
import java.util.Optional;

public interface AllocationService {

    Allocation createAllocation(Allocation allocation);

    List<Allocation> fetchAllAllocation();

    Optional<Allocation> getAllocationById(Integer id);
}
