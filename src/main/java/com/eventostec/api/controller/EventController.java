package com.eventostec.api.controller;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventRequestDTO body){
        Event newEvent = eventService.createEvent(body);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable UUID id){
        return ResponseEntity.ok(eventService.getById(id));
    }
}