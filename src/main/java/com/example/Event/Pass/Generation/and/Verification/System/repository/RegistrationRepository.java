package com.example.Event.Pass.Generation.and.Verification.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Event.Pass.Generation.and.Verification.System.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
