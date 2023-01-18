package com.cicm.zonesservice.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record CreateSensorRequestDto(
        String name,
        String description,
        String zoneId
) {
}
