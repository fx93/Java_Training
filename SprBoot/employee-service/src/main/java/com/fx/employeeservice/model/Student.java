package com.fx.employeeservice.model;


import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    @Id
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Fx", 98));
        studentList.add(new Student("Kumar", 76));
        studentList.add(new Student("Jeano", 90));
        studentList.add(new Student("David", 65));
        studentList.add(new Student("Kiri", 44));
        return studentList;
    }
}
