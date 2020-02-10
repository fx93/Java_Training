package com.fx.employeeservice.repository;


import com.fx.employeeservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    // Student save(Student student);
}
