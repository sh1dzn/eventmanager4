package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id") // Соответствие с таблицей: participant_id
    private Integer id;

    // Связь с Event: столбец event_id в таблице Participant
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private String name;
    private String email;

    public Participant() {
    }

    public Participant(Event event, String name, String email) {
        this.event = event;
        this.name = name;
        this.email = email;
    }

    // Геттеры и сеттеры

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}