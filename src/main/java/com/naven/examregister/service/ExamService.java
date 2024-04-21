package com.naven.examregister.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naven.examregister.domain.Exam;
import com.naven.examregister.repository.ExamRepo;


@Service
public class ExamService {

    @Autowired
    private ExamRepo exp;
    
    public List<Exam> getAllExams() {
        // Retrieve all exams from the repository
        return exp.findAll();
    }

    public void save(Exam newexam) {
        exp.save(newexam);
    }
  
}

