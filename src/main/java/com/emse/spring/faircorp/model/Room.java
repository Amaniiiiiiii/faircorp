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

    private Double currentTemperature;

    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> Heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> Windows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Set<Heater> getHeaters() {
        return Heaters;
    }

    public void setHeaters(Set<Heater> heaters) {
        Heaters = heaters;
    }

    public Set<Window> getWindows() {
        return Windows;
    }

    public void setWindows(Set<Window> windows) {
        Windows = windows;
    }
}
