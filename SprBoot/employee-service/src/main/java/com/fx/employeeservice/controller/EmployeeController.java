package com.fx.employeeservice.controller;

import com.fx.employeeservice.model.Employee;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping("hello")
    public String hello(){
        return "Hello world from SpringBoot";
    }

    @RequestMapping(value = "/details", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> getEmployees(){
        return Employee.getAllEmployees();
    }

}