
package com.cicm.zonesservice.controller;

import com.cicm.zonesservice.dto.request.CreateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.request.UpdateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.response.GetAllIrrigationMachinesResponseDto;
import com.cicm.zonesservice.dto.response.GetIrrigationMachineDetailsResponseDto;
import com.cicm.zonesservice.model.IrrigationMachine;
import com.cicm.zonesservice.service.IrrigationMachineService;
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
@RequestMapping("/api/irrigation-machines")
public class IrrigationMachineController {

    private IrrigationMachineService irrigationMachineService;

    @PostMapping("")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> createIrrigationMachine(
            @Valid @RequestBody CreateIrrigationMachineRequestDto dto
    ) {
        IrrigationMachine irrigationMachine = irrigationMachineService.createIrrigationMachine(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(irrigationMachine.getId())
                .toUri();

        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{machineId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> updateIrrigationMachine(
            UpdateIrrigationMachineRequestDto dto,
            @PathVariable("machineId") String machineId
    ) {
        IrrigationMachine irrigationMachine = irrigationMachineService.updateIrrigationMachine(machineId, dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(irrigationMachine.getId())
                .toUri();

        return ResponseEntity.status(204)
                .location(location)
                .build();
    }

    @DeleteMapping("/{machineId}")
    @PostAuthorize("hasAuthority('FARM_ADMIN')")
    public ResponseEntity<Void> deleteIrrigationMachine(@PathVariable("machineId") String machineId) {
        irrigationMachineService.deleteIrrigationMachine(machineId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    @PostAuthorize("isAuthenticated()")
    public ResponseEntity<List<GetAllIrrigationMachinesResponseDto>> getAllIrrigationMachines() {

        return ResponseEntity.ok()
                .body(irrigationMachineService.getAllIrrigationMachines());
    }

    @GetMapping("/{machineId}")
    @PostAuthorize("isAuthenticated()")
    public ResponseEntity<GetIrrigationMachineDetailsResponseDto> getIrrigationMachineDetails(
            @PathVariable("machineId") String machineId
    ) {
        return ResponseEntity.ok()
                .body(irrigationMachineService.getIrrigationMachineDetails(machineId));
    }

}
