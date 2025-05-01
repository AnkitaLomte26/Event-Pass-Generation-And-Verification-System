package com.eventregistration.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.eventregistration.model.Event;
import com.eventregistration.service.EventService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EventService eventService;
    
    public DataInitializer(EventService eventService) {
        this.eventService = eventService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Create sample events
        createSampleEvents();
    }
    
    private void createSampleEvents() {
        // Event 1 - Unlocked
        Event event1 = new Event();
        event1.setId(1);
        event1.setTitle("Coding Hackathon 2025");
        event1.setStatus("Unlocked");
        event1.setDate("June 20, 2025");
        event1.setTime("10:00 AM - 6:00 PM");
        event1.setLocation("Tech Hub, Main Campus");
        event1.setOrganizer("Computer Science Department");
        event1.setFee("₹500");
        event1.setImage("/static/images/coding-hackathon.jpg");
        event1.setDescription("Join us for an exciting day of coding challenges and innovation. This hackathon is designed for students of all skill levels who want to test their programming abilities and work on creative solutions.");
        
        event1.setLearnings(Arrays.asList(
            "Problem-solving skills in a competitive environment",
            "Team collaboration techniques",
            "Latest programming tools and frameworks",
            "Pitching and presentation skills"
        ));
        
        event1.setHighlights(Arrays.asList(
            "Cash prizes worth ₹50,000",
            "Industry expert mentors",
            "Networking opportunities",
            "Certificate of participation",
            "Free food and refreshments"
        ));
        
        event1.setSchedule(Arrays.asList(
            "10:00 AM - Registration and Team Formation",
            "11:00 AM - Kickoff and Challenge Announcement",
            "12:00 PM - Coding Begins",
            "2:00 PM - Lunch Break",
            "5:00 PM - Final Submissions",
            "5:30 PM - Project Presentations",
            "6:00 PM - Award Ceremony"
        ));
        
        // Event 2 - Locked
        Event event2 = new Event();
        event2.setId(2);
        event2.setTitle("AI Workshop Series");
        event2.setStatus("Locked");
        event2.setDate("July 15, 2025");
        event2.setTime("9:00 AM - 4:00 PM");
        event2.setLocation("Innovation Center, East Wing");
        event2.setOrganizer("AI Research Club");
        event2.setFee("₹750");
        event2.setImage("/static/images/ai-workshop.jpg");
        event2.setDescription("A comprehensive workshop series on Artificial Intelligence fundamentals and applications. Learn about machine learning, neural networks, and how to implement AI solutions for real-world problems.");
        
        event2.setLearnings(Arrays.asList(
            "AI and Machine Learning basics",
            "Neural network architecture",
            "Data preprocessing techniques",
            "Model training and evaluation",
            "Practical AI implementation"
        ));
        
        event2.setHighlights(Arrays.asList(
            "Hands-on training sessions",
            "Take-home projects",
            "Industry case studies",
            "Professional certification",
            "Job placement assistance"
        ));
        
        event2.setSchedule(Arrays.asList(
            "9:00 AM - Introduction to AI concepts",
            "10:30 AM - Machine Learning Algorithms",
            "12:00 PM - Lunch and Networking",
            "1:00 PM - Practical Session: Building Your First AI Model",
            "3:00 PM - Q&A and Future Learning Paths",
            "4:00 PM - Certification Distribution"
        ));
        
        // Event 3 - Locked
        Event event3 = new Event();
        event3.setId(3);
        event3.setTitle("Cybersecurity Summit");
        event3.setStatus("Locked");
        event3.setDate("August 5, 2025");
        event3.setTime("10:00 AM - 5:00 PM");
        event3.setLocation("Security Conference Hall");
        event3.setOrganizer("Cybersecurity Excellence Center");
        event3.setFee("₹1000");
        event3.setImage("/static/images/cybersecurity-summit.jpg");
        event3.setDescription("Learn about the latest threats, defense mechanisms, and best practices in cybersecurity from industry experts and practitioners. This summit covers everything from network security to ethical hacking.");
        
        event3.setLearnings(Arrays.asList(
            "Current cybersecurity landscape",
            "Threat detection and prevention",
            "Security auditing techniques",
            "Incident response planning",
            "Ethical hacking methodologies"
        ));
        
        event3.setHighlights(Arrays.asList(
            "Live hacking demonstrations",
            "Security tools showcase",
            "One-on-one with security experts",
            "Cyber defense competition",
            "Industry recognized certification"
        ));
        
        event3.setSchedule(Arrays.asList(
            "10:00 AM - Keynote: The Evolving Threat Landscape",
            "11:30 AM - Panel Discussion: Security in the Digital Age",
            "1:00 PM - Lunch Break",
            "2:00 PM - Workshop: Vulnerability Assessment",
            "3:30 PM - Live Demo: Ethical Hacking Techniques",
            "5:00 PM - Closing Remarks and Networking"
        ));
        
        // Save events
        eventService.saveEvent(event1);
        eventService.saveEvent(event2);
        eventService.saveEvent(event3);
    }
}