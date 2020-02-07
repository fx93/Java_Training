package com.fx.employeeservice.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private int marks;

    public Employee(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee("Fx", 98));
        employeeList.add(new Employee("Kumar", 76));
        employeeList.add(new Employee("Jeano", 90));
        employeeList.add(new Employee("David", 65));
        employeeList.add(new Employee("Kiri", 44));
        return employeeList;
    }
}
