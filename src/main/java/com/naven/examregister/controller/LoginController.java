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
        } else if (Objects.nonNull(oauthUser)) {
            // If successful, redirect to display page with username parameter
            String username = user.getUsername();
            return "redirect:/display?username=" + username;
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
                     @RequestParam("email") String email,
                     @RequestParam("password") String password,
                     @RequestParam("confirmPassword") String confirmPassword, Model model) {
    // Check if the username or email already exists
    if (signUpService.existsByUsername(username) || signUpService.existsByEmail(email)) {
        // Username or email already exists, handle this scenario
        // You can redirect to a signup page with an error message
        model.addAttribute("error", "User exists");

        return "signup";
    }

    // Check if the password and confirm password match
    if (!password.equals(confirmPassword)) {
        // Passwords don't match, handle this scenario
        // You can redirect to a signup page with an error message
        model.addAttribute("error", "Passwords don't match");

        return "signup";
    }

    // If everything is fine, proceed with creating a new SignUp object and saving it
    try {
        SignUp signUp = new SignUp(username, email, password, confirmPassword);
        signUpService.save(signUp);
        Login1 login = new Login1(username,password);
        service.save(login);
    } catch (Exception e) {
        e.printStackTrace(); // Log the exception or handle it appropriately
    }// Redirect to login page after sign-up
    return "redirect:/login";
}

    @GetMapping("/profile")
    public String showprofile(@RequestParam("username") String username,Model model) {
        List<RegisteredUser> registeredCourses = registeredUserService.getRegisteredCoursesByUsername(username);
        SignUp user = signUpService.findByUsername(username);

    // Pass registered courses and username to the view
        model.addAttribute("username", username);
        model.addAttribute("user", user);
        model.addAttribute("registeredCourses", registeredCourses);
        
        return "profile";
    }
    
    @GetMapping("/register")
    public String showRegistrationPage(@RequestParam("username") String username,
                                   @RequestParam("examTitle") String examTitle,
                                   Model model) {
    // Pass username and exam title to the registration page
    model.addAttribute("username", username);
    model.addAttribute("examTitle", examTitle);
    return "register";
}



    @PostMapping("/register")
    public String registerUser(@RequestParam("firstName") String firstname,
                                @RequestParam("lastName") String lastname,
                                @RequestParam("college") String college,

                                @RequestParam("department") String department,
                                @RequestParam("yearOfStudy") String year_of_study,
                                @RequestParam("examTitle") String exam_title,
                                @RequestParam("username") String username) {
    RegisteredUser reg = new RegisteredUser(username,firstname,lastname,exam_title,college,department,year_of_study);
   
   registeredUserService.saveUser(reg);
    return "redirect:/success?username=" + username; // Redirect to success page
}
@GetMapping("/display")
public String display(Model model, @RequestParam("username") String username) {
    // Get all exams from the service
    List<Exam> exams = examservice.getAllExams();
    // Add exams and username to the model
    model.addAttribute("exams", exams);
    model.addAttribute("username", username);
    return "display";
}

    @GetMapping("/success")
    public String showSuccessPage(@RequestParam("username") String username,Model model)  {
        model.addAttribute("username", username);
        return "success";
    }   
}

