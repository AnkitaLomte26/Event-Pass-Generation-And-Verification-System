package com.example.Event.Pass.Generation.and.Verification.System.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String collegeName;
    private String rollNo;
    private String department;
    private String year;

    private String paymentProofPath; // path where screenshot saved

    @Column(length = 1000)
    private String anyQuestion;
}
