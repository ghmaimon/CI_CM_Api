package com.cicm.zonesservice.dto.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record GetAllIrrigationMachinesResponseDto
        (
                String id,
                String name,
                String zoneId
        ){
}
