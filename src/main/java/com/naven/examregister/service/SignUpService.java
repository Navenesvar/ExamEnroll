package com.naven.examregister.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naven.examregister.domain.SignUp;
import com.naven.examregister.repository.SignUpRepository;


@Service
public class SignUpService {

    @Autowired
    private SignUpRepository signUpRepository;

    public void save(SignUp signUp) {
        signUpRepository.save(signUp);
    }

    public List<SignUp> getAllUserDetails() {
        return signUpRepository.findAll();

    }

   
   
   
   
}

