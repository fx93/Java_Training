package com.alfar.demo.services;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alfar.demo.hystrix.CommonHystrix;
import com.alfar.demo.model.Allocation;
import com.alfar.demo.model.Telephone;
import com.alfar.demo.model.student;
import com.alfar.demo.repository.StudentRepository;



@Service
public class StudentServiceImpl implements Studentservice {

	@Autowired
	StudentRepository studentrepo;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		
		
		return builder.build() ;
	}
	
	@Autowired
    RestTemplate restTemplate;
	
	public student save(student stu) {
		
		for(Telephone tp : stu.getTelephone()) {
			
			tp.setStudent(stu);
		}
		
		
		return studentrepo.save(stu);
	}


	@Override
	public Optional<student> findById(int id) {
		
		return studentrepo.findById(id);
	}


	private Allocation[] getAllocation(int studentid) throws InterruptedException, ExecutionException {
		
		CommonHystrix<Allocation[]> AllocationHystrix = new CommonHystrix<Allocation[]>("default", ()->{
			
			return restTemplate.getForObject("http://allocation/allocation/findbyid/"+ studentid,Allocation[].class);
			
			
		},()->{
			
			
			return new Allocation[] {};
			
		});  
		
		//Allocation[] allocation = restTemplate.getForObject("http://allocation/allocation/findbyid/"+ studentid,Allocation[].class);
		
		//return allocation;
		
		Future<Allocation[]> allocationfuture = AllocationHystrix.queue();
		
		return allocationfuture.get();
	}
	

	@Override
	public student fetchAllAllocations(int Studentid) throws InterruptedException, ExecutionException {
		
		Optional<student> students = studentrepo.findById(Studentid);
		
		
		
		if(students.isPresent()) {
			
			student objstudent = students.get();
			
			/*
			HttpHeaders httpHeaders = new HttpHeaders();
			
			HttpEntity<String> httpEntity = new HttpEntity<String>("",httpHeaders);
			
		
			
			ResponseEntity<Allocation[]> responseEntity =  restTemplate.exchange(
					"http://allocation/allocation/findbyid/"+ studentid, HttpMethod.GET, httpEntity, Allocation[].class);
			*/
			objstudent.setAllocations(getAllocation(Studentid));
			
				
			
			return objstudent;
			
		}
		
		return null;
	}
		
		
	
	
}
