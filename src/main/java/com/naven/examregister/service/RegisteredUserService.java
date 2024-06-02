package com.naven.examregister.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<RegisteredUser> getRegisteredCoursesByUsername(String username) {
        return registeredUserRepository.findByUsername(username);
    }

    public Map<String, List<String>> getRegisteredUsersByExamTitle() {
    List<RegisteredUser> registeredUsers = registeredUserRepository.findAll();
    Map<String, List<String>> usersByExamTitle = new HashMap<>();
    for (RegisteredUser user : registeredUsers) {
        String examTitle = user.getExamTitle();
        String username = user.getUsername();
        usersByExamTitle.computeIfAbsent(examTitle, k -> new ArrayList<>()).add(username);
    }
    return usersByExamTitle;
}

}

