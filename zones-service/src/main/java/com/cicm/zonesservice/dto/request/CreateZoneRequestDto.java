package com.cicm.zonesservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateZoneRequestDto {
    private Long length;
    private Long width;
    @NotNull
    private Long size;
    private String physicalLocation;
}
