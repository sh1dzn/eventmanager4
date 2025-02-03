package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.entity.Participant;
import com.example.demo.entity.EventManager;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.ParticipantRepository;
import com.example.demo.repository.EventManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EventManagerRepository eventManagerRepository;

    // Эндпоинты для работы с событиями

    // Получить список всех событий
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Создать новое событие
    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    // Эндпоинты для участников

    // Получить список всех участников
    @GetMapping("/participants")
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Создать нового участника
    @PostMapping("/participants")
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantRepository.save(participant);
    }

    // Эндпоинты для менеджеров событий

    // Получить список всех менеджеров
    @GetMapping("/managers")
    public List<EventManager> getAllManagers() {
        return eventManagerRepository.findAll();
    }

    // Создать нового менеджера
    @PostMapping("/managers")
    public EventManager createManager(@RequestBody EventManager manager) {
        return eventManagerRepository.save(manager);
    }
}