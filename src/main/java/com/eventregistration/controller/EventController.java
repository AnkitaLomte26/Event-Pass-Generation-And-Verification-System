package com.eventregistration.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventregistration.model.Event;
import com.eventregistration.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {
    
    private final EventService eventService;
    
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping
    public String listEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "event-list";
    }
    
// In EventController.java
@GetMapping("/api/events/{id}")  // Changed from "/events/{id}" to "/api/events/{id}"
public String viewEvent(@PathVariable Integer id, Model model) {
    // Your existing code

        // Get the event by ID
        Event event = eventService.getEventById(id);
        
        // If event not found, redirect to events list
        if (event == null) {
            return "redirect:/events";
        }
        
        model.addAttribute("event", event);
        return "event-details";
    }
    
    @GetMapping("/create")
    public String createEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event-form";
    }
    
    @GetMapping("/edit/{id}")
    public String editEventForm(@PathVariable Integer id, Model model) {
        // Get the event by ID
        Event event = eventService.getEventById(id);
        
        // If event not found, redirect to events list
        if (event == null) {
            return "redirect:/events";
        }
        
        model.addAttribute("event", event);
        return "event-form";
    }
}