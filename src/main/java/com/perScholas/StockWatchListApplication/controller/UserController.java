package com.perScholas.StockWatchListApplication.controller;

import com.perScholas.StockWatchListApplication.model.User;
import com.perScholas.StockWatchListApplication.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Show home page
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("activePage", "home"); // Set active page for home
        return "home"; // This refers to home.html
    }
    // Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Create a new User object to bind form fields
        model.addAttribute("activePage", "register"); // Set active page for registration
        return "register"; // Return the registration template
    }
    @GetMapping("/features")
    public String featuresPage(Model model) {
        model.addAttribute("activePage", "features");
        return "features";
    }
    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("activePage", "contact");
        return "contact";
    }
    // Handle user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        try {
            userService.registerUser(user); // Call service to register user
            return "redirect:/users/login"; // Redirect to login page upon successful registration
        } catch (RuntimeException e) {
            model.addAttribute("error", "Email already exists"); // Handle user already exists error
            model.addAttribute("activePage", "register"); // Keep registration as the active page
            return "register"; // Return to registration page with error
        }
    }

   //  Show login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("activePage", "login"); // Set active page for login
        return "login"; // Return the login template
    }

    // Handle user login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            User user = userService.loginUser(email, password); // Call service to validate user
            return "redirect:/watchlists?userId=" + user.getId(); // Redirect to watchlists page upon successful login
        } catch (RuntimeException e) {
            model.addAttribute("error", "Invalid email or password"); // Handle invalid credentials error
            model.addAttribute("activePage", "login"); // Keep login as the active page
            return "login"; // Return to login page with error
        }
    }




    }


//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        try {
//            User savedUser = userService.registerUser(user);
//            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
//        try {
//            userService.loginUser(loginUser.getEmail(), loginUser.getPassword());
//            return new ResponseEntity<>("Login successful", HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
//        }
//    }
//}