package com.example.Event.Pass.Generation.and.Verification.System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Event.Pass.Generation.and.Verification.System.model.Registration;
import com.example.Event.Pass.Generation.and.Verification.System.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerForEvent(Registration registration) {
        return registrationRepository.save(registration);
    }
}
