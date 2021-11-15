package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HeaterDto {
    private Long id;
    private String name;
    private long power;
    private HeaterStatus heaterStatus;
    private Long roomId;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.heaterStatus = heater.getHeaterStatus();
        this.roomId = heater.getRoom().getId();
    }
}
