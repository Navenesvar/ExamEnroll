package com.naven.examregister.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naven.examregister.domain.RegisteredUser;
import com.naven.examregister.repository.RegisteredUserRepository;


@Service
public class RegisteredUserService {

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    public void saveUser(RegisteredUser registeredUser) {
        registeredUserRepository.save(registeredUser);
    }

    public List<RegisteredUser> getAllRegisteredStudents() {
        return registeredUserRepository.findAll();
    }

}

