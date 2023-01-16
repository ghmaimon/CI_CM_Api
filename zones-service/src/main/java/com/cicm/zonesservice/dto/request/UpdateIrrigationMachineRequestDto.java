package com.cicm.zonesservice.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UpdateIrrigationMachineRequestDto
        (
            String name,
            String description,
            List<String> kpis,
            String zoneId
        )
{ }
