package com.training.salesmanager.repository;

import com.training.salesmanager.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//name value derived from implemented interface
@Repository("employeeRepository")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List getAllEmployees(){
        List<Employee> employeeList = new ArrayList<>();

        Employee employee = new Employee();
        employee.setEmployeeName("fx");
        employee.setEmployeeLocation("Delft");
        employeeList.add(employee);

        return employeeList;
    }
}
