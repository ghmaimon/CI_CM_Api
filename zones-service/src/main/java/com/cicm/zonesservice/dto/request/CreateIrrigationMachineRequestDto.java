package com.cicm.zonesservice.dto.request;

import com.cicm.zonesservice.model.Zone;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateIrrigationMachineRequestDto
        (
            @NotNull String name,
            String description,
            String zoneId
        )
{ }
