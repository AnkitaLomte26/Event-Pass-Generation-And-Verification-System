package com.example.Event.Pass.Generation.and.Verification.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Event.Pass.Generation.and.Verification.System.service.UserService;

@SpringBootApplication
public class EventPassGenerationAndVerificationSystemApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(EventPassGenerationAndVerificationSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create admin user at startup
        userService.createAdminUser();
    }
}