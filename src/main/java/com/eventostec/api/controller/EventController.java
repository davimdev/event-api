package com.eventostec.api.controller;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody @Valid EventRequestDTO body){
        Event newEvent = eventService.createEvent(body);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable UUID id){
        return ResponseEntity.ok(eventService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> update(
            @PathVariable UUID id,
            @RequestBody EventRequestDTO body
    ){
        return ResponseEntity.ok(eventService.updateEvent(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}