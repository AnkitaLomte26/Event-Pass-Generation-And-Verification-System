package com.example.Event.Pass.Generation.and.Verification.System.controller;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "home"; // Your landing page
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/admin-dashboard";
        }
        return "redirect:/events";
    }
}