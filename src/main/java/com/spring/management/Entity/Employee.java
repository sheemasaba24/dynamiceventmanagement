package com.spring.management.Entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String employeeName;
    private String employeeEmail;
    private String designation;

   
    public Employee() {}

   
    public Employee(Long id, String employeeName, String employeeEmail,String designation) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeEmail=employeeEmail;
        this.designation = designation;
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
