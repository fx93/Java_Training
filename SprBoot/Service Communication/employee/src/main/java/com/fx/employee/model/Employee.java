package com.fx.employee.model;

import com.fx.employee.sharedmodel.Allocation;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String city;

    Allocation[] allocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Allocation[] getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation[] allocation) {
        this.allocation = allocation;
    }
}
