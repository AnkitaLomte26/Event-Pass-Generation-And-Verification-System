package com.eventregistration.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventregistration.model.Registration;
import com.eventregistration.repository.RegistrationRepository;

@Service
public class RegistrationService {
    
    private final RegistrationRepository registrationRepository;
    private final EventService eventService;
    
    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, EventService eventService) {
        this.registrationRepository = registrationRepository;
        this.eventService = eventService;
    }
    
    // Create a new registration
    public Registration createRegistration(Registration registration) {
        // Check if the event exists and is unlocked
        if (!eventService.isEventUnlocked(registration.getEventId())) {
            throw new IllegalArgumentException("Event is locked or doesn't exist");
        }
        
        // Generate a unique registration ID if not provided
        if (registration.getRegistrationId() == null || registration.getRegistrationId().isEmpty()) {
            registration.setRegistrationId(generateRegistrationId());
        }
        
        return registrationRepository.save(registration);
    }
    
    // Get all registrations for an event
    public List<Registration> getRegistrationsByEventId(Integer eventId) {
        return registrationRepository.findByEventId(eventId);
    }
    
    // Get registration by ID
    public Optional<Registration> getRegistrationById(Integer id) {
        return registrationRepository.findById(id);
    }
    
    // Get registration by registration ID
    public Registration getRegistrationByRegistrationId(String registrationId) {
        return registrationRepository.findByRegistrationId(registrationId);
    }
    
    // Generate a unique registration ID (4-digit number)
    private String generateRegistrationId() {
        Random random = new Random();
        return String.format("%04d", 1000 + random.nextInt(9000)); // 4-digit number between 1000-9999
    }
}