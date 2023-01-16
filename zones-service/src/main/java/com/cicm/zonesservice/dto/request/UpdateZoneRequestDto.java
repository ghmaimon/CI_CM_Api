package com.cicm.zonesservice.dto.request;

import jakarta.validation.constraints.NotNull;


public record UpdateZoneRequestDto (
        Long length,
        Long width,
        @NotNull Long size,
        String physicalLocation
){
}
