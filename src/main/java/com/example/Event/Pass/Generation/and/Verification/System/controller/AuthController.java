
package com.example.Event.Pass.Generation.and.Verification.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Event.Pass.Generation.and.Verification.System.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository; // Inject repository to access DB

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject BCrypt password encoder


    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // points to login.html
    }

    // Handle login POST request
    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {
        //  login logic
        return "home";
    }

    // Show admin login page (optional if you separate it)
    @GetMapping("/adminLogin")
    public String showAdminLoginPage() {
        return "adminLogin"; // create adminLogin.html (only if needed separately)
    }

    @PostMapping("/adminLogin")
    public String adminLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
      //admin login
      return "home";
    }

    // Send OTP handler (if you have email verification)
    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email, Model model) {
        System.out.println("Sending OTP to: " + email);
        model.addAttribute("email", email);
        return "verify-otp"; // Create verify-otp.html if you use this
    }
    
}