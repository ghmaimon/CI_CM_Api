package com.cicm.zonesservice.controller;

import com.cicm.zonesservice.dto.request.CreatePlantRequestDto;
import com.cicm.zonesservice.dto.request.UpdatePlantRequestDto;
import com.cicm.zonesservice.dto.response.GetAllPlantsResponseDto;
import com.cicm.zonesservice.dto.response.GetPlantDetailsResponseDto;
import com.cicm.zonesservice.model.Plant;
import com.cicm.zonesservice.service.PlantService;
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
@RequestMapping("/api/plants")
public class PlantController {

    private PlantService plantService;

    @PostMapping("")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> createPlant(
            @Valid @RequestBody CreatePlantRequestDto dto
    ) {
        Plant plant = plantService.createPlant(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(plant.getId())
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{plantId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> updatePlant(
            UpdatePlantRequestDto dto,
            @PathVariable("plantId") String plantId
    ) {
        Plant plant = plantService.updatePlant(plantId, dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(plant.getId())
                .toUri();

        return ResponseEntity.status(204)
                .location(location)
                .build();
    }

    @DeleteMapping("/{plantId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> deletePlant(@PathVariable("plantId") String plantId) {
        plantService.deletePlant(plantId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @PostAuthorize("isAuthenticated()")
    public ResponseEntity<List<GetAllPlantsResponseDto>> getAllPlants() {

        return ResponseEntity.ok()
                .body(plantService.getAllPlants());
    }

    @GetMapping("/sensor-id/{sensorId}")
    ResponseEntity<GetPlantDetailsResponseDto> getplantWithSensorId(
            @PathVariable("sensorId") String sensorId
    ) {
        GetPlantDetailsResponseDto dto = plantService.getPlantWithSensorId(sensorId);
        return ResponseEntity.ok()
                .body(dto);
    }


    @GetMapping("/{plantId}")
    @PostAuthorize("isAuthenticated()")
    public ResponseEntity<GetPlantDetailsResponseDto> getPlantDetails(
            @PathVariable("plantId") String plantId
    ) {
        return ResponseEntity.ok()
                .body(plantService.getPlantDetails(plantId));
    }

}
