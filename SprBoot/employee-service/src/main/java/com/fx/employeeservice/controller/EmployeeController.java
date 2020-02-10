package com.fx.employeeservice.controller;

import com.fx.employeeservice.model.Employee;
import com.fx.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("hello")
    public String hello(){
        return "<h1>Hello world from SpringBoot</h1>";
    }

    @RequestMapping(value = "/employeeSave", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

}