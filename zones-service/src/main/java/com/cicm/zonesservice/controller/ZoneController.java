package com.cicm.zonesservice.controller;

import com.cicm.zonesservice.dto.request.CreateZoneRequestDto;
import com.cicm.zonesservice.dto.request.UpdateZoneRequestDto;
import com.cicm.zonesservice.dto.response.GetAllZonesResponseDto;
import com.cicm.zonesservice.dto.response.GetZoneDetailsResponseDto;
import com.cicm.zonesservice.model.Zone;
import com.cicm.zonesservice.service.ZoneService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/zones")
public class ZoneController {

    private ZoneService zoneService;

    @PostMapping("")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> createZone(
            @Valid @RequestBody CreateZoneRequestDto dto
    ) {
        Zone zone = zoneService.createZone(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(zone.getId())
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{zoneId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> updateZone(
            UpdateZoneRequestDto dto,
            @PathVariable("zoneId") String zoneId
    ) {
        Zone zone = zoneService.updateZone(zoneId, dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(zone.getId())
                .toUri();

        return ResponseEntity.status(204)
                .location(location)
                .build();
    }

    @DeleteMapping("/{zoneId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> deleteZone(@PathVariable("zoneId") String zoneId) {
        zoneService.deleteZone(zoneId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<GetAllZonesResponseDto>> getAllZones() {

        return ResponseEntity.ok()
                .body(zoneService.getAllZones());
    }

    @GetMapping("/{zoneId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<GetZoneDetailsResponseDto> getZoneDetails(
            @PathVariable("zoneId") String zoneId
    ) {
        return ResponseEntity.ok()
                .body(zoneService.getZoneDetails(zoneId));
    }

}
