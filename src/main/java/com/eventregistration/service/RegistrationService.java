package com.eventregistration.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.eventregistration.model.Registration;
import com.eventregistration.repository.RegistrationRepository;

@Service
public class RegistrationService {
    
    private final RegistrationRepository registrationRepository;
    
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    
    // Create a new registration
    public Registration createRegistration(Registration registration) {
        // Set creation timestamp
        registration.setTimestamp(LocalDateTime.now());
        
        // Generate a unique registration ID if not provided
        if (registration.getRegistrationId() == null || registration.getRegistrationId().isEmpty()) {
            registration.setRegistrationId(generateRegistrationId());
        }
        
        return registrationRepository.save(registration);
    }
    
    // Generate a unique registration ID
    private String generateRegistrationId() {
        return "REG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
    // Get registration by ID
    public Optional<Registration> getRegistrationById(Integer id) {
        return registrationRepository.findById(id);
    }
    
    // Get registrations by event ID
    public List<Registration> getRegistrationsByEventId(Integer eventId) {
        return registrationRepository.findByEventId(eventId);
    }
    
    // Delete a registration
    public void deleteRegistration(Integer id) {
        registrationRepository.deleteById(id);
    }
}