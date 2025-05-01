package com.eventregistration.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    private Integer id;
    
    private String title;
    private String image;
    private String date;
    private String time;
    private String location;
    private String status; // "Locked" or "Unlocked"
    private String fee;
    private String organizer;
    
    @Column(length = 1000)
    private String description;
    
    @ElementCollection
    @CollectionTable(name = "event_highlights", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "highlight")
    private List<String> highlights;
    
    @ElementCollection
    @CollectionTable(name = "event_learnings", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "learning")
    private List<String> learnings;
    
    @ElementCollection
    @CollectionTable(name = "event_schedule", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "schedule_item")
    private List<String> schedule;
    
    // Constructors
    public Event() {}
    
    public Event(Integer id, String title, String image, String date, String time, String location, 
                String status, String fee, String organizer, String description, 
                List<String> highlights, List<String> learnings, List<String> schedule) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.date = date;
        this.time = time;
        this.location = location;
        this.status = status;
        this.fee = fee;
        this.organizer = organizer;
        this.description = description;
        this.highlights = highlights;
        this.learnings = learnings;
        this.schedule = schedule;
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getFee() {
        return fee;
    }
    
    public void setFee(String fee) {
        this.fee = fee;
    }
    
    public String getOrganizer() {
        return organizer;
    }
    
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<String> getHighlights() {
        return highlights;
    }
    
    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }
    
    public List<String> getLearnings() {
        return learnings;
    }
    
    public void setLearnings(List<String> learnings) {
        this.learnings = learnings;
    }
    
    public List<String> getSchedule() {
        return schedule;
    }
    
    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }
}