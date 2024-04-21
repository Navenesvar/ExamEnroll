package com.naven.examregister.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naven.examregister.domain.Exam;
import java.util.List;


@Repository
public interface ExamRepo extends JpaRepository<Exam, Integer> {
    // Add custom query methods for exams if needed
    List<Exam> findAll();
    @SuppressWarnings("unchecked")
    Exam save(Exam newexam);
    Exam findByTitle(String title);
}

