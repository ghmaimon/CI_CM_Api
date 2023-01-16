package com.cicm.zonesservice.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreatePlantRequestDto(
        @NotNull String name,
        String description
) {
}
