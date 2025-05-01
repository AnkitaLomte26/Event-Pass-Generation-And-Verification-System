package com.eventregistration.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.eventregistration.model.Event;
import com.eventregistration.service.EventService;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private final EventService eventService;
    
    @Autowired
    public DataInitializer(EventService eventService) {
        this.eventService = eventService;
    }
    
    @Override
    public void run(String... args) {
        // Initialize with demo events only if the database is empty
        if (eventService.getAllEvents().isEmpty()) {
            initializeDemoEvents();
        }
    }
    
    private void initializeDemoEvents() {
        // Event 1: Tech Summit (Unlocked)
        Event techSummit = new Event();
        techSummit.setId(1);
        techSummit.setTitle("Tech Summit 2023");
        techSummit.setImage("https://images.unsplash.com/photo-1540575467063-178a50c2df87?w=500");
        techSummit.setDate("June 20, 2025");
        techSummit.setTime("9:00 AM - 5:00 PM");
        techSummit.setLocation("Main Campus Auditorium");
        techSummit.setStatus("Unlocked");
        techSummit.setFee("$50");
        techSummit.setOrganizer("Tech Club");
        techSummit.setDescription("Join us for a day of workshops, talks, and networking with industry experts.");
        techSummit.setHighlights(Arrays.asList(
            "Keynote Speakers",
            "Networking Opportunities",
            "Hands-on Workshops",
            "Panel Discussions"
        ));
        techSummit.setLearnings(Arrays.asList(
            "Web Development",
            "Mobile App Development",
            "Cloud Computing",
            "Machine Learning"
        ));
        techSummit.setSchedule(Arrays.asList(
            "9:00 AM - Registration",
            "10:00 AM - Opening Keynote",
            "12:00 PM - Lunch Break",
            "1:30 PM - Workshops",
            "4:00 PM - Closing Remarks"
        ));
        
        // Event 2: Design Workshop (Locked)
        Event designWorkshop = new Event();
        designWorkshop.setId(2);
        designWorkshop.setTitle("Design Workshop");
        designWorkshop.setImage("https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=500");
        designWorkshop.setDate("July 15, 2025");
        designWorkshop.setTime("1:00 PM - 6:00 PM");
        designWorkshop.setLocation("Design Center, Room 201");
        designWorkshop.setStatus("Locked");
        designWorkshop.setFee("$35");
        designWorkshop.setOrganizer("Design Association");
        designWorkshop.setDescription("An intensive workshop on UI/UX design principles and practices.");
        designWorkshop.setHighlights(Arrays.asList(
            "Professional Instructors",
            "Small Group Sessions",
            "Portfolio Review",
            "Design Challenges"
        ));
        designWorkshop.setLearnings(Arrays.asList(
            "User Interface Design",
            "User Experience Principles",
            "Information Architecture",
            "Design Systems"
        ));
        designWorkshop.setSchedule(Arrays.asList(
            "1:00 PM - Check-in",
            "1:30 PM - Design Theory Session",
            "3:00 PM - Break",
            "3:30 PM - Practical Workshop",
            "5:30 PM - Q&A"
        ));
        
        // Event 3: Entrepreneurship Conference (Locked)
        Event entrepreneurshipConference = new Event();
        entrepreneurshipConference.setId(3);
        entrepreneurshipConference.setTitle("Entrepreneurship Conference");
        entrepreneurshipConference.setImage("https://images.unsplash.com/photo-1552664730-d307ca884978?w=500");
        entrepreneurshipConference.setDate("August 5, 2025");
        entrepreneurshipConference.setTime("10:00 AM - 4:00 PM");
        entrepreneurshipConference.setLocation("Business School Hall");
        entrepreneurshipConference.setStatus("Locked");
        entrepreneurshipConference.setFee("$75");
        entrepreneurshipConference.setOrganizer("Startup Incubator");
        entrepreneurshipConference.setDescription("Learn from successful entrepreneurs and connect with potential investors.");
        entrepreneurshipConference.setHighlights(Arrays.asList(
            "Successful Entrepreneurs",
            "Investor Pitch Session",
            "Business Plan Workshop",
            "Networking Lunch"
        ));
        entrepreneurshipConference.setLearnings(Arrays.asList(
            "Business Plan Development",
            "Fundraising Strategies",
            "Marketing Fundamentals",
            "Financial Planning"
        ));
        entrepreneurshipConference.setSchedule(Arrays.asList(
            "10:00 AM - Welcome",
            "10:30 AM - Entrepreneur Panel",
            "12:30 PM - Networking Lunch",
            "2:00 PM - Pitch Competition",
            "3:30 PM - Awards"
        ));
        
        // Save all events
        List<Event> events = Arrays.asList(techSummit, designWorkshop, entrepreneurshipConference);
        events.forEach(eventService::saveEvent);
        
        System.out.println("Demo events initialized successfully!");
    }
}