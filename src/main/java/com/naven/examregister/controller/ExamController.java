package com.naven.examregister.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.naven.examregister.domain.Exam;
import com.naven.examregister.domain.RegisteredUser;
import com.naven.examregister.domain.SignUp;
import com.naven.examregister.service.ExamService;
import com.naven.examregister.service.RegisteredUserService;
import com.naven.examregister.service.SignUpService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ExamController {
    @Autowired
    private RegisteredUserService registeredUserService;
    @Autowired
    private SignUpService signUpService;
    @Autowired
    private ExamService examservice;
  
    
    @GetMapping("/registration")
    public String showRegisteredStudents(Model model) {
       List<RegisteredUser> students = registeredUserService.getAllRegisteredStudents();
       List<SignUp> users = signUpService.getAllUserDetails();
       Map<String, List<String>> usersByExamTitle = registeredUserService.getRegisteredUsersByExamTitle();
    model.addAttribute("usersByExamTitle", usersByExamTitle);
       model.addAttribute("students", students);
       model.addAttribute("users", users);
       return "registration";
    }

    @GetMapping("/addexam")
    public String showexamform() {
        return "addexam";
    }

    @PostMapping("/addexam")
    public String publishexam(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("date") String dateString) {
  
        Exam newexam = new Exam(title, description, dateString);
        examservice.save(newexam);
        return "redirect:/success2";
}
    @GetMapping("/success2")
    public String examsuccess() {
        return "success2";
    }  
    
}
