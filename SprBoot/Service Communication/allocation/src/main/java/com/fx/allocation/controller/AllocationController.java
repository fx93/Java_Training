package com.fx.allocation.controller;

import com.fx.allocation.model.Allocation;
import com.fx.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public Allocation createAllocation(@RequestBody Allocation allocation) {
        return allocationService.createAllocation(allocation);
    }

    @RequestMapping(value = "/allocation/{id}", method = RequestMethod.GET)
    public Optional<Allocation> fetchAllocationsById(@PathVariable(value = "id") Integer id) {
        return allocationService.getAllocationById(id);
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public List<Allocation> fetchAllAllocation() {
        return allocationService.fetchAllAllocation();
    }
}
