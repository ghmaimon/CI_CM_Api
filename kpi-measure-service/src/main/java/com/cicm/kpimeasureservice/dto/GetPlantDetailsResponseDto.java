package com.cicm.kpimeasureservice.dto;

public record GetPlantDetailsResponseDto(
        String id,
        String name,
        String description,
        Long lowerWaterThreshold,
        Long upperWaterThreshold,
        String zoneId
) {
}
