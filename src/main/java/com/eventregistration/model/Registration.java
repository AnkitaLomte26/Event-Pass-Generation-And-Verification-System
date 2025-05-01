package com.eventregistration.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "event_id")
    private Integer eventId;
    
    private String username;
    private String email;
    private String mobile;
    private String college;
    private String department;
    private String year;
    
    @Column(name = "payment_option")
    private String paymentOption;
    
    @Column(name = "payment_proof")
    private String paymentProof;
    
    @Column(name = "registration_id")
    private String registrationId;
    
    private LocalDateTime timestamp;
    
    // Constructors
    public Registration() {
        this.timestamp = LocalDateTime.now();
    }
    
    public Registration(Integer eventId, String username, String email, String mobile, 
                       String college, String department, String year, String paymentOption,
                       String paymentProof, String registrationId) {
        this.eventId = eventId;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.college = college;
        this.department = department;
        this.year = year;
        this.paymentOption = paymentOption;
        this.paymentProof = paymentProof;
        this.registrationId = registrationId;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getEventId() {
        return eventId;
    }
    
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getCollege() {
        return college;
    }
    
    public void setCollege(String college) {
        this.college = college;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getPaymentOption() {
        return paymentOption;
    }
    
    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }
    
    public String getPaymentProof() {
        return paymentProof;
    }
    
    public void setPaymentProof(String paymentProof) {
        this.paymentProof = paymentProof;
    }
    
    public String getRegistrationId() {
        return registrationId;
    }
    
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}