package com.eventregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventregistration.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}