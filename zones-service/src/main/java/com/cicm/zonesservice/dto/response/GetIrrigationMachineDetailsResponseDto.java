package com.cicm.zonesservice.dto.response;

import java.util.List;

public record GetIrrigationMachineDetailsResponseDto (
        String name,
        String description,
        List<String> kpis,
        String zoneId
) {
}
