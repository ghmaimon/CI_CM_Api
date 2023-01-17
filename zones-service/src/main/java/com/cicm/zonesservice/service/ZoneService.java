package com.cicm.zonesservice.service;

import com.cicm.zonesservice.dto.request.CreateZoneRequestDto;
import com.cicm.zonesservice.dto.request.UpdateZoneRequestDto;
import com.cicm.zonesservice.dto.response.GetAllZonesResponseDto;
import com.cicm.zonesservice.dto.response.GetZoneDetailsResponseDto;
import com.cicm.zonesservice.model.Zone;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ZoneService {
    Zone createZone(CreateZoneRequestDto dto);
    Zone updateZone(String zoneId, UpdateZoneRequestDto dto);
    GetZoneDetailsResponseDto getZoneDetails(String zoneId);
    List<GetAllZonesResponseDto> getAllZones();
    void deleteZone(String zoneId);
    Zone findZone(String zoneId);
}
