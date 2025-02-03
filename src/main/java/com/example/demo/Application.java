package com.example.demo;

import com.example.demo.entity.Event;
import com.example.demo.entity.Participant;
import com.example.demo.entity.EventManager;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.ParticipantRepository;
import com.example.demo.repository.EventManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializer(EventRepository eventRepository,
                                             ParticipantRepository participantRepository,
                                             EventManagerRepository managerRepository) {
        return args -> {
            // Создаем события
            Event event1 = new Event("Tech Conference", LocalDate.of(2025, 2, 10), "Astana");
            Event event2 = new Event("Music Festival", LocalDate.of(2025, 3, 20), "Almaty");
            eventRepository.save(event1);
            eventRepository.save(event2);

            // Создаем участников для event1
            Participant participant1 = new Participant(event1, "Alice", "alice@example.com");
            Participant participant2 = new Participant(event1, "Bob", "bob@example.com");
            participantRepository.save(participant1);
            participantRepository.save(participant2);

            // Создаем менеджеров
            EventManager manager1 = new EventManager("Manager One", "manager1@example.com");
            EventManager manager2 = new EventManager("Manager Two", "manager2@example.com");
            managerRepository.save(manager1);
            managerRepository.save(manager2);
        };
    }
}