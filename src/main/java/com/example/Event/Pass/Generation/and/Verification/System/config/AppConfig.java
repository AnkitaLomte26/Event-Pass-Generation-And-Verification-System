package com.example.Event.Pass.Generation.and.Verification.System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  // Ensure this is present
public class AppConfig {
    @Bean
    public BCryptPasswordEncoder customPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}