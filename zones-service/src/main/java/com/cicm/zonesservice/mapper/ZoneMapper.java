package com.cicm.zonesservice.mapper;

import com.cicm.zonesservice.dto.request.CreateZoneRequestDto;
import com.cicm.zonesservice.dto.response.GetAllZonesResponseDto;
import com.cicm.zonesservice.dto.response.GetZoneDetailsResponseDto;
import com.cicm.zonesservice.model.Zone;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ZoneMapper {
    Zone createZoneRequestDtoToZoneMapper(CreateZoneRequestDto dto);
    GetZoneDetailsResponseDto zoneToGetZoneDetailsResponseDtoMapper(Zone zone);
    GetAllZonesResponseDto zoneToGetAllZonesResponseDtoMapper(Zone zone);
}
