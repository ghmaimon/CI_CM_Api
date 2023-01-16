package com.cicm.zonesservice.dto.request;

import com.cicm.zonesservice.model.Zone;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

public record CreateSensorRequestDto(
        String name,
        String description,
        @NotNull
        Date orderDate,
        String zoneId
) {
}
