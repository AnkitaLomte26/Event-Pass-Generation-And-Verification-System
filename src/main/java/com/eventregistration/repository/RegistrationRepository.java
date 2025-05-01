package com.eventregistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventregistration.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    
    List<Registration> findByEventId(Integer eventId);
    
}