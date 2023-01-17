package com.cicm.zonesservice.controller;

import com.cicm.zonesservice.dto.request.CreateSensorRequestDto;
import com.cicm.zonesservice.dto.request.UpdateSensorRequestDto;
import com.cicm.zonesservice.dto.response.GetAllSensorsResponseDto;
import com.cicm.zonesservice.dto.response.GetSensorDetailsResponseDto;
import com.cicm.zonesservice.model.Sensor;
import com.cicm.zonesservice.service.SensorService;
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
@RequestMapping("/api/sensors")
public class SensorController {

    private SensorService sensorService;

    @PostMapping("")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> createSensor(
            @Valid @RequestBody CreateSensorRequestDto dto
    ) {
        Sensor sensor = sensorService.createSensor(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sensor.getId())
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }

    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    @PutMapping("/{sensorId}")
    public ResponseEntity<Void> updateSensor(
            UpdateSensorRequestDto dto,
            @PathVariable("sensorId") String sensorId
    ) {
        Sensor sensor = sensorService.updateSensor(sensorId, dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sensor.getId())
                .toUri();

        return ResponseEntity.status(204)
                .location(location)
                .build();
    }

    @DeleteMapping("/{sensorId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> deleteSensor(@PathVariable("sensorId") String sensorId) {
        sensorService.deleteSensor(sensorId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @PostAuthorize("isAuthenticated()")
    public ResponseEntity<List<GetAllSensorsResponseDto>> getAllSensors() {

        return ResponseEntity.ok()
                .body(sensorService.getAllSensors());
    }

    @GetMapping("/{sensorId}")
    @PostAuthorize("isAuthenticated()")
    public ResponseEntity<GetSensorDetailsResponseDto> getSensorDetails(
            @PathVariable("sensorId") String sensorId
    ) {
        return ResponseEntity.ok()
                .body(sensorService.getSensorDetails(sensorId));
    }

}
