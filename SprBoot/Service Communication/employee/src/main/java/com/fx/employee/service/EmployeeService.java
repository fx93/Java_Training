package com.fx.employee.service;

import com.fx.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> fetchAll();

    Employee getEmployee(Integer id);
}
