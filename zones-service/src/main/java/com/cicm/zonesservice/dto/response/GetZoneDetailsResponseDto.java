package com.cicm.zonesservice.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetZoneDetailsResponseDto {
    private Long length;
    private Long width;
    private Long size;
    private String physicalLocation;
}
