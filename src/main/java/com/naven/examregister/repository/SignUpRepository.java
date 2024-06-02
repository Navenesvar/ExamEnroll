package com.naven.examregister.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naven.examregister.domain.SignUp;



@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Integer> {
    // Add custom query methods if needed
    List<SignUp> findAll();
    @SuppressWarnings("unchecked")
    SignUp save(SignUp signUp);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    SignUp findByUsername(String username);
}

