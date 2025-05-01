package com.eventregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventregistration.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    // Find all registrations for a specific event
    List<Registration> findByEventId(Integer eventId);
    
    // Find a registration by its unique registration ID
    Registration findByRegistrationId(String registrationId);
}