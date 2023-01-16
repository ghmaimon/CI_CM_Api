package com.cicm.zonesservice.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateZoneRequestDto (
        Long length,
        Long width,
        @NotNull(message = "size must not be null") Long size,
        String physicalLocation
){
}
