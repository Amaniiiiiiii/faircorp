package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false,length = 255)
    private String name;

    private double currentTemprature;

    private double targetTemprature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> Heaters;

    @OneToMany
    @ManyToOne
    private Set<Window> Windows;
}