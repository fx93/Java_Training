package com.training.salesmanager.service;

import com.training.salesmanager.model.Employee;
import com.training.salesmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    // EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();
    // @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(){
        System.out.println("Deafult Constructor");
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        System.out.println("Overloaded Constructor");
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository){
        System.out.println("setter injection fired");
        this.employeeRepository = employeeRepository;
    }

    public EmployeeRepository getEmployeeRepository(){
        return employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }
}
