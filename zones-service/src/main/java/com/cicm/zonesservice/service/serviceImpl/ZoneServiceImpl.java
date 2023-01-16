package com.cicm.zonesservice.service.serviceImpl;

import com.cicm.zonesservice.dto.request.CreateZoneRequestDto;
import com.cicm.zonesservice.dto.request.UpdateZoneRequestDto;
import com.cicm.zonesservice.dto.response.GetAllZonesResponseDto;
import com.cicm.zonesservice.dto.response.GetZoneDetailsResponseDto;
import com.cicm.zonesservice.exception.ZoneNotFoundException;
import com.cicm.zonesservice.mapper.ZoneMapper;
import com.cicm.zonesservice.model.Zone;
import com.cicm.zonesservice.repository.ZoneRepository;
import com.cicm.zonesservice.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Primary
public class ZoneServiceImpl implements ZoneService {

    private ZoneRepository zoneRepository;
    private ZoneMapper zoneMapper;

    public Zone createZone(CreateZoneRequestDto dto) {
        return zoneRepository.save(
                zoneMapper.createZoneRequestDtoToZoneMapper(dto)
        );
    }

    public Zone updateZone(String zoneId, UpdateZoneRequestDto dto) {
        Zone zone = findZone(zoneId);

        if (dto.size() != null) zone.setSize(dto.size());
        if (dto.width() != null) zone.setWidth(dto.width());
        if (dto.length() != null) zone.setLength(dto.length());
        if (dto.physicalLocation() != null) zone.setPhysicalLocation(dto.physicalLocation());

        return zone;
    }

    public GetZoneDetailsResponseDto getZoneDetails(String zoneId) {
        return zoneMapper.zoneToGetZoneDetailsResponseDtoMapper(
                findZone(zoneId)
        );
    }

    public List<GetAllZonesResponseDto> getAllZones() {
        return zoneRepository.findAll()
                .stream()
                .map(zoneMapper::zoneToGetAllZonesResponseDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Zone findZone(String zoneId) {
        return zoneRepository.findById(zoneId).orElseThrow(
                () -> new ZoneNotFoundException(zoneId)
        );
    }

    public void deleteZone(String zoneId) {
        zoneRepository.delete(
                findZone(zoneId)
        );
    }

}
