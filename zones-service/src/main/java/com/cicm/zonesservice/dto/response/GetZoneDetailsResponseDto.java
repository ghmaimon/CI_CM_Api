package com.cicm.zonesservice.dto.response;

public record GetZoneDetailsResponseDto (
    Long length,
    Long width,
    Long size,
    String physicalLocation
){}
