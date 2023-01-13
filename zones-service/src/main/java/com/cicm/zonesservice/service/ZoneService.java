package com.cicm.zonesservice.service;

import com.cicm.zonesservice.dto.request.CreateZoneRequestDto;
import com.cicm.zonesservice.dto.request.UpdateZoneRequestDto;
import com.cicm.zonesservice.dto.response.GetAllZonesResponseDto;
import com.cicm.zonesservice.dto.response.GetZoneDetailsResponseDto;
import com.cicm.zonesservice.exception.ZoneNotFoundException;
import com.cicm.zonesservice.mapper.ZoneMapper;
import com.cicm.zonesservice.model.Zone;
import com.cicm.zonesservice.repository.ZoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ZoneService {

    private ZoneRepository zoneRepository;
    private ZoneMapper zoneMapper;

    public Zone createZone(CreateZoneRequestDto dto) {

        return zoneRepository.save(
                zoneMapper.createZoneRequestDtoToZoneMapper(dto)
        );
    }

    public Zone updateZone(String zoneId, UpdateZoneRequestDto dto) {
        Zone zone = zoneRepository.findById(zoneId).orElseThrow(
                () -> new ZoneNotFoundException(zoneId)
        );

        if (dto.getSize() != null) zone.setSize(dto.getSize());
        if (dto.getWidth() != null) zone.setWidth(dto.getWidth());
        if (dto.getLength() != null) zone.setLength(dto.getLength());
        if (dto.getPhysicalLocation() != null) zone.setPhysicalLocation(dto.getPhysicalLocation());

        return zone;
    }

    public GetZoneDetailsResponseDto getZoneDetails(String zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElseThrow(
                () -> new ZoneNotFoundException(zoneId)
        );

        return zoneMapper.zoneToGetZoneDetailsResponseDtoMapper(zone);
    }

    public List<GetAllZonesResponseDto> getAllZones() {
        return zoneRepository.findAll()
                .stream()
                .map(zoneMapper::zoneToGetAllZonesResponseDtoMapper)
                .collect(Collectors.toList());
    }

    public void deleteZone(String zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElseThrow(
                () -> new ZoneNotFoundException(zoneId)
        );

        zoneRepository.delete(zone);
    }

}
