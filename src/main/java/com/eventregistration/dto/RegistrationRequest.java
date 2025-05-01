package com.eventregistration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {
    
    @NotNull(message = "Event ID is required")
    private Integer eventId;
    
    @NotBlank(message = "Full name is required")
    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String username;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;
    
    @NotBlank(message = "Mobile number is required")
    @Size(min = 10, max = 15, message = "Please enter a valid mobile number")
    private String mobile;
    
    @NotBlank(message = "College name is required")
    @Size(min = 2, message = "College name must be at least 2 characters long")
    private String college;
    
    @NotBlank(message = "Department is required")
    private String department;
    
    @NotBlank(message = "Year is required")
    private String year;
    
    @NotBlank(message = "Payment option is required")
    private String paymentOption;
    
    // Payment proof is not required for cash payments
    private String paymentProof;
    
    // Getters and Setters
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
}