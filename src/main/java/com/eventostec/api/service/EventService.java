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
        String imgUrl = null;

        if(data.image() != null){
            imgUrl = this.uploadImg(data.image());
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.data()));
        newEvent.setImgUrl(imgUrl);

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

}
