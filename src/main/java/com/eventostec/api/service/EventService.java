package com.eventostec.api.service;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import com.eventostec.api.repository.EventRepository;

import java.util.Date;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(EventRequestDTO data){
        String imgUrl = "https://via.placeholder.com/150";

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.data()));
        newEvent.setImgUrl(imgUrl);
        newEvent.setRemote(data.remote());
        newEvent.setCity(data.city());
        newEvent.setState(data.state());

        return eventRepository.save(newEvent);
    }

    private String uploadImg(MultipartFile multipartFile){
        return "";
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getById(UUID id){
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    public Event updateEvent(UUID id, EventRequestDTO data){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        if (data.title() != null){
            event.setTitle(data.title());
        }

        if (data.description() != null){
            event.setDescription(data.description());
        }

        if (data.eventUrl() != null){
            event.setEventUrl(data.eventUrl());
        }

        if (data.data() != null){
            event.setDate(new Date(data.data()));
        }

        return eventRepository.save(event);
    }

    public void deleteEvent(UUID id){
        if (!eventRepository.existsById(id)){
            throw new RuntimeException("Evento não encontrado");
        }
        eventRepository.deleteById(id);
    }
}
