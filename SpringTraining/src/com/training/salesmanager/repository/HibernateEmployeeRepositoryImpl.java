package com.training.salesmanager.repository;

import com.training.salesmanager.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//name value derived from implemented interface
@Repository("employeeRepositoryTest")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

    @Value("${name}")
    private String employeeName;
    @Value("${location}")
    private String employeeCity;

    @Override
    public List getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();

        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        employee.setEmployeeLocation(employeeCity);
        employeeList.add(employee);

        return employeeList;
    }
}
