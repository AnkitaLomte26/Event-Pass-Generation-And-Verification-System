
package com.example.Event.Pass.Generation.and.Verification.System.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Event.Pass.Generation.and.Verification.System.model.User;
import com.example.Event.Pass.Generation.and.Verification.System.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/signup")  // Added to display the signup form
    public String showSignUpForm() {
        return "signup"; //  signup.html
    }

    @PostMapping("/register")
    public String handleRegistration(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model,
            RedirectAttributes redirectAttributes) {

        // Validate data (server-side validation)
        if (username == null || username.trim().isEmpty() || username.length() < 3) {
            model.addAttribute("error", "Username must be at least 3 characters long.");
            return "signup";
        }
        if (email == null || email.trim().isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            model.addAttribute("error", "Invalid email format.");
            return "signup";
        }
        if (password == null || password.trim().isEmpty() || password.length() < 6) {
            model.addAttribute("error", "Password must be at least 6 characters long.");
            return "signup";
        }
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "signup";
        }

        // Check if username or email already exists
        Optional<User> existingUserByUsername = userRepository.findByUsername(username);
        if (existingUserByUsername.isPresent()) {
            model.addAttribute("error", "Username already exists.");
            return "signup";
        }

        Optional<User> existingUserByEmail = userRepository.findByEmail(email);
        if (existingUserByEmail.isPresent()) {
            model.addAttribute("error", "Email already exists.");
            return "signup";
        }

        // Create new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPasswordHash(passwordEncoder.encode(password)); // Encode the password
        newUser.setRegistrationDate(LocalDateTime.now());
        newUser.setRole("user"); // Set default role
        userRepository.save(newUser);

        redirectAttributes.addFlashAttribute("message", "Registration successful! Please login.");
        return "redirect:/login"; // Redirect to login page
    }
}