package com.eventregistration.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eventregistration.dto.RegistrationRequest;
import com.eventregistration.model.Event;
import com.eventregistration.model.Registration;
import com.eventregistration.service.EventService;
import com.eventregistration.service.RegistrationService;

import jakarta.validation.Valid;

@Controller
public class WebController {

    private final EventService eventService;
    private final RegistrationService registrationService;

    public WebController(EventService eventService, RegistrationService registrationService) {
        this.eventService = eventService;
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "index";
    }

    @GetMapping("/events/{id}")
    public String eventDetails(@PathVariable Integer id, Model model) {
        Event event = eventService.getEventById(id);
        
        if (event == null) {
            return "redirect:/";
        }
        
        model.addAttribute("event", event);
        return "event-details";
    }
    
    @GetMapping("/event-details/{id}")
    public String eventDetailsAlternate(@PathVariable Integer id, Model model) {
        return eventDetails(id, model);
    }

    @GetMapping("/register/{eventId}")
    public String showRegistrationForm(@PathVariable Integer eventId, Model model) {
        Event event = eventService.getEventById(eventId);
        
        if (event == null) {
            return "redirect:/";
        }
        
        // Check if the event is unlocked
        if (!"Unlocked".equals(event.getStatus())) {
            return "redirect:/events/" + eventId;
        }
        
        model.addAttribute("event", event);
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "registration-form";
    }
    
    @GetMapping("/registration-form/{id}")
    public String registrationFormAlternate(@PathVariable Integer id, Model model) {
        return showRegistrationForm(id, model);
    }

    @PostMapping("/register")
    public String processRegistration(
            @Valid @ModelAttribute("registrationRequest") RegistrationRequest registrationRequest,
            BindingResult bindingResult,
            @RequestParam("paymentProofFile") MultipartFile paymentProofFile,
            Model model) {
        
        // Get the event
        Event event = eventService.getEventById(registrationRequest.getEventId());
        if (event == null) {
            return "redirect:/";
        }
        
        model.addAttribute("event", event);
        
        // Validate form
        if (bindingResult.hasErrors()) {
            return "registration-form";
        }
        
        // Validate payment proof if not cash payment
        if (!"cash".equals(registrationRequest.getPaymentOption()) && 
            (paymentProofFile == null || paymentProofFile.isEmpty())) {
            bindingResult.rejectValue("paymentOption", "error.paymentProof", 
                                     "Payment proof is required for non-cash payments");
            return "registration-form";
        }
        
        try {
            // Process payment proof file if provided
            String paymentProofFileName = null;
            if (paymentProofFile != null && !paymentProofFile.isEmpty()) {
                // Create uploads directory if it doesn't exist
                Path uploadsDir = Paths.get("uploads");
                if (!Files.exists(uploadsDir)) {
                    Files.createDirectories(uploadsDir);
                }
                
                // Generate a unique filename
                paymentProofFileName = UUID.randomUUID().toString() + "_" + 
                                      paymentProofFile.getOriginalFilename();
                Path filePath = uploadsDir.resolve(paymentProofFileName);
                
                // Save the file
                Files.copy(paymentProofFile.getInputStream(), filePath);
            }
            
            // Create registration
            Registration registration = new Registration();
            registration.setEventId(registrationRequest.getEventId());
            registration.setUsername(registrationRequest.getUsername());
            registration.setEmail(registrationRequest.getEmail());
            registration.setMobile(registrationRequest.getMobile());
            registration.setCollege(registrationRequest.getCollege());
            registration.setDepartment(registrationRequest.getDepartment());
            registration.setYear(registrationRequest.getYear());
            registration.setPaymentOption(registrationRequest.getPaymentOption());
            registration.setPaymentProof(paymentProofFileName);
            
            // Save registration
            Registration savedRegistration = registrationService.createRegistration(registration);
            
            // Redirect to event pass page
            return "redirect:/event-pass/" + savedRegistration.getId();
            
        } catch (IOException e) {
            // Handle file upload error
            model.addAttribute("error", "Failed to upload payment proof: " + e.getMessage());
            return "registration-form";
        }
    }

    @GetMapping("/event-pass/{registrationId}")
    public String showEventPass(@PathVariable Integer registrationId, Model model) {
        Optional<Registration> registrationOpt = registrationService.getRegistrationById(registrationId);
        
        if (registrationOpt.isEmpty()) {
            return "redirect:/";
        }
        
        Registration registration = registrationOpt.get();
        Event event = eventService.getEventById(registration.getEventId());
        
        if (event == null) {
            return "redirect:/";
        }
        
        model.addAttribute("registration", registration);
        model.addAttribute("event", event);
        return "event-pass";
    }
}