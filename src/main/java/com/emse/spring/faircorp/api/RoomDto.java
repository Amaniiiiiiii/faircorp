package com.emse.spring.faircorp.api;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private Integer floor;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;


}
