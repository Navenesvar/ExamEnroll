package com.naven.examregister.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registered_user")
public class RegisteredUser {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String username; // Added username field
    private String firstname;
    private String lastname;
    private String college;
    private String department;
    private String year_of_study;
    private String exam_title; // Added examTitle field

    // Constructors, getters, and setters
    public RegisteredUser() {
    }

    public RegisteredUser(String username, String firstName, String lastName, String examTitle, String college, String department, String yearOfStudy) {
        this.username = username;
        this.firstname = firstName;
        this.lastname = lastName;
        this.exam_title = examTitle;
        this.college = college;
        this.department = department;
        this.year_of_study = yearOfStudy;
    }

    // Getters and setters

    public int getId() {
        return sno;
    }

    public void setId(int id) {
        this.sno = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
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

    public String getExamTitle() {
        return exam_title;
    }

    public void setExamTitle(String examTitle) {
        this.exam_title = examTitle;
    }
}
