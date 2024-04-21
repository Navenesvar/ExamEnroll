package com.naven.examregister.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naven.examregister.domain.Exam;
import com.naven.examregister.domain.Login1;
import com.naven.examregister.repository.ExamRepo;
import com.naven.examregister.repository.LoginRepo;


@Service
public class LoginService {

    @Autowired
    private LoginRepo rep;
    @Autowired
    private ExamRepo exp;

    public Login1 log(String username, String password) {
        return rep.findByUsernameAndPassword(username, password);
    }
  
    public void save(Login1 login1) {
        rep.save(login1);
    }

    public Exam getExamByTitle(String title) {
        return exp.findByTitle(title);
    }
    public List<Exam> getAllExams() {
        // Retrieve all exams from the repository
        return exp.findAll();
    }
    
    
}
