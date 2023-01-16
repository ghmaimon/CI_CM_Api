package com.cicm.zonesservice.dto.response;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record GetSensorDetailsResponseDto(
        String name,
        String description,
        Date orderDate,
        String zoneId
) {
}
