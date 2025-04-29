package com.example.Event.Pass.Generation.and.Verification.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Event.Pass.Generation.and.Verification.System.model.Event;
import com.example.Event.Pass.Generation.and.Verification.System.repository.EventRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public String showEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "events"; // you will create events.html later
    }

    @GetMapping("/eventDetails/{id}")
    public String showEventDetails(@PathVariable("id") Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);
        model.addAttribute("event", event);
        return "eventDetails"; // you will create eventDetails.html later
    }
}