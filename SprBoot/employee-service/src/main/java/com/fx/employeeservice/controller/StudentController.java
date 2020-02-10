package com.fx.employeeservice.controller;

import com.fx.employeeservice.model.Student;
import com.fx.employeeservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getEmployees(@PathVariable int id){
        List<Student> studentList = Student.getAllStudents();

        for(Student student: studentList){
            if(student.getId() == id){
                return student;
            }
        }
        return new Student(null,0);
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Student Save(@RequestBody Student student){
        return studentService.save(student);
    }
}
