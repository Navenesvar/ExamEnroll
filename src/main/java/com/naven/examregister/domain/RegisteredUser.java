package com.naven.examregister.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="register")
public class RegisteredUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    private String firstname;
    private String lastname;
    private String college;
    private String department;
    private String year_of_study;

    // Constructors, getters, and setters
    public RegisteredUser() {}

    public RegisteredUser(String firstName, String lastName, String college, String department, String yearOfStudy) {
        this.firstname = firstName;
        this.lastname = lastName;
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
}
