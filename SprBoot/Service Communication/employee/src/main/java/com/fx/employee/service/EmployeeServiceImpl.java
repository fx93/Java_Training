package com.fx.employee.service;

import com.fx.employee.model.Employee;
import com.fx.employee.repository.EmployeeRepository;
import com.fx.employee.sharedmodel.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;



@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee fetchEmployee(int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {

            Employee employee = optional.get();

            ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange("http://localhost:9191/allo_service/fetch_f_emp/" + id, HttpMethod.POST, httpEntity, Allocation[].class);

            employee.setAllocation(responseEntity.getBody());

            return employee;
        } else {
            return null;
        }
    }


}
