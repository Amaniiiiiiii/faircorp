package com.emse.spring.faircorp.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "HEATER")
public class Heater {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,length = 255)
    private String name;

    @Column(nullable = true)
    private Long power;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Room room;

    public Heater() {
    }

    public Heater(Room room) {
        this.room = room;
    }

    public Heater(Long id, String name, Long power, Room room, HeaterStatus heaterStatus) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.room = room;
        this.heaterStatus = heaterStatus;
    }

    public Heater(String name,HeaterStatus heaterStatus, Room room) {
        this.name = name;
        this.room = room;
        this.heaterStatus = heaterStatus;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
