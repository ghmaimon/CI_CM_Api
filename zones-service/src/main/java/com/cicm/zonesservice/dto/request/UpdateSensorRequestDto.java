package com.cicm.zonesservice.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record UpdateSensorRequestDto
        (
            String name,
            String description,
            String zoneId
            )
{ }
