package com.naven.examregister.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naven.examregister.domain.Exam;
import com.naven.examregister.domain.Login1;
import com.naven.examregister.domain.RegisteredUser;
import com.naven.examregister.domain.SignUp;
import com.naven.examregister.service.ExamService;
import com.naven.examregister.service.LoginService;
import com.naven.examregister.service.RegisteredUserService;
import com.naven.examregister.service.SignUpService;


@Controller
public class LoginController {

    @Autowired
    private LoginService service;
    @Autowired
    private ExamService examservice;

    @Autowired
    private SignUpService signUpService;
    @Autowired
    private RegisteredUserService registeredUserService;

    @GetMapping("/")
    public String showLoginForm(Model model) {
        // Add a Login1 object to the model for the form
        model.addAttribute("user", new Login1());
        return "login";
    }
    @GetMapping("/login")
    public String showForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login1 user, Model model) {
        // Check if login is successful
        Login1 oauthUser = service.log(user.getUsername(), user.getPassword());
        if (user.getUsername().equals("admin") && user.getPassword().equals("exam")) {
            // If the user is an admin, redirect to the registration page
            return "redirect:/registration";
        }
        else if (Objects.nonNull(oauthUser)) {
            // If successful, redirect to display page
            String name = user.getUsername();
            System.out.println("Username:"+name);
            model.addAttribute("name", name);
            return "redirect:/display";
        } else {
            // If unsuccessful, add error message to model and return to login page
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("college") String college,
                         @RequestParam("department") String department,
                         @RequestParam("year_of_study") String year_of_study) {
        SignUp signUp = new SignUp(username, password, college, department, year_of_study);
        signUpService.save(signUp);
        Login1 login1 = new Login1(username,password);
        service.save(login1);
        return "redirect:/login"; // Redirect to login page after sign-up
    }
    @GetMapping("/profile")
    public String showprofile() {
        return "profile";
    }
    
    @GetMapping("/register")
        public String showRegistrationPage(){
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@RequestParam("firstName") String firstname,
                                @RequestParam("lastName") String lastname,
                                @RequestParam("college") String college,

                                @RequestParam("department") String department,
                                @RequestParam("yearOfStudy") String year_of_study) {
    RegisteredUser reg = new RegisteredUser(firstname,lastname,college,department,year_of_study);
   
   registeredUserService.saveUser(reg);
    return "redirect:/success"; // Redirect to success page
}
    @GetMapping("/display")
    public String display(Model model) {
        // Get all exams from the service
        List<Exam> exams = examservice.getAllExams();

        // Add exams to the model
        model.addAttribute("exams", exams);
        return "display";
    }
    @GetMapping("/success")
    public String showSuccessPage()  {
        return "success";
    }
    
    
}

