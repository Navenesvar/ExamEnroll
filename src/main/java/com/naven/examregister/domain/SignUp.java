package com.naven.examregister.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="signup")
public class SignUp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;
    private String password;
    private String college;
    private String department;
    private String year_of_study;
    
    // Constructors, getters, and setters
    public SignUp() {
    }

    public SignUp(String username, String password, String college, String department, String yearOfStudy) {
        this.username = username;
        this.password = password;
        this.college = college;
        this.department = department;
        this.year_of_study = yearOfStudy;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearOfStudy() {
        return year_of_study;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.year_of_study = yearOfStudy;
    }
}
