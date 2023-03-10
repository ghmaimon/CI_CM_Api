package com.cicm.zonesservice.dto.response;

public record GetPlantDetailsResponseDto(
        String id,
        String name,
        String description,
        Long lowerWaterThreshold,
        Long upperWaterThreshold,
        String zoneId
) {
}
