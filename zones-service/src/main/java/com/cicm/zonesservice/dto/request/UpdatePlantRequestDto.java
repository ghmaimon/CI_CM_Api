package com.cicm.zonesservice.dto.request;

public record UpdatePlantRequestDto(
        String name,
        String description,
        Float lowerWaterThreshold,
        Float upperWaterThreshold
) {
}
