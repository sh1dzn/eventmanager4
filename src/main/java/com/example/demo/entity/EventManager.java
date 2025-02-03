package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "EventManager")
public class EventManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id") // Соответствие с таблицей: manager_id
    private Integer id;

    private String name;
    private String contact;

    public EventManager() {
    }

    public EventManager(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    // Геттеры и сеттеры

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}