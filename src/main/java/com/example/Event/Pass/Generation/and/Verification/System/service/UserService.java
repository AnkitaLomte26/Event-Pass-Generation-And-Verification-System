/*package com.example.Event.Pass.Generation.and.Verification.System.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Event.Pass.Generation.and.Verification.System.model.User;
import com.example.Event.Pass.Generation.and.Verification.System.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Automatically runs after the bean initialization
    @PostConstruct
    public void init() {
        createAdminUser();
    }

    // This method creates admin if not exists
    public void createAdminUser() {
        Optional<User> existingAdmin = userRepository.findByUsername("admin@college.com");
        if (existingAdmin.isEmpty()) {
            User adminUser = new User();
            adminUser.setUsername("admin@college.com");
            adminUser.setPasswordHash(passwordEncoder.encode("admin123"));
            adminUser.setEmail("admin@college.com");
            adminUser.setRole("admin");

            userRepository.save(adminUser);
        }
    }
}*/
package com.example.Event.Pass.Generation.and.Verification.System.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Event.Pass.Generation.and.Verification.System.model.User;
import com.example.Event.Pass.Generation.and.Verification.System.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Automatically runs after the bean initialization
    @PostConstruct
    public void init() {
        createAdminUser();
    }
    
    // This method creates admin if not exists
    public void createAdminUser() {
        Optional<User> existingAdmin = userRepository.findByUsername("admin@college.com");
        if (existingAdmin.isEmpty()) {
            User adminUser = new User();
            adminUser.setUsername("admin@college.com");
            adminUser.setPasswordHash(passwordEncoder.encode("admin123"));
            adminUser.setEmail("admin@college.com");
            adminUser.setRole("admin");
            userRepository.save(adminUser);
        }
    }

     public User save(User user) { //added save
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }
}