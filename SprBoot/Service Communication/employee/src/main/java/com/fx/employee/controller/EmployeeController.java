package com.fx.employee.controller;

import com.fx.employee.model.Employee;
import com.fx.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value ="/saveemployees", method = RequestMethod.POST)
    public Employee storeEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @RequestMapping("/fetch")
    public List<Employee> fetchAllEmployees() {
        return employeeService.fetchAll();

    }
}
