package com.eventregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventregistration.model.Event;
import com.eventregistration.repository.EventRepository;

@Service
public class EventService {
    
    private final EventRepository eventRepository;
    
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    
    // Get event by ID - Updated to return Event directly instead of Optional
    public Event getEventById(Integer id) {
        return eventRepository.findById(id).orElse(null);
    }
    
    // Check if an event is unlocked
    public boolean isEventUnlocked(Integer id) {
        Event event = getEventById(id);
        return event != null && "Unlocked".equals(event.getStatus());
    }
    
    // Save or update an event
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    
    // Delete an event
    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}