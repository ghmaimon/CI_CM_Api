package com.cicm.zonesservice.service.serviceImpl;

import com.cicm.zonesservice.dto.request.CreateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.request.UpdateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.response.GetAllIrrigationMachinesResponseDto;
import com.cicm.zonesservice.dto.response.GetIrrigationMachineDetailsResponseDto;
import com.cicm.zonesservice.exception.IrrigationMachineNotFoundException;
import com.cicm.zonesservice.mapper.IrrigationMachineMapper;
import com.cicm.zonesservice.model.IrrigationMachine;
import com.cicm.zonesservice.model.Zone;
import com.cicm.zonesservice.repository.IrrigationMachineRepository;
import com.cicm.zonesservice.service.IrrigationMachineService;
import com.cicm.zonesservice.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Primary
public class IrrigationMachineServiceImpl implements IrrigationMachineService {

    private IrrigationMachineRepository irrigationMachineRepository;
    private IrrigationMachineMapper irrigationMachineMapper;
    private ZoneService zoneService;

    public IrrigationMachine createIrrigationMachine(CreateIrrigationMachineRequestDto dto) {
        IrrigationMachine machine =
                irrigationMachineMapper.createIrrigationMachineRequestDtoToIrrigationMachineMapper(dto);
        machine.setZone(
                zoneService.findZone(dto.zoneId())
        );

        return irrigationMachineRepository.save(machine);
    }

    public IrrigationMachine updateIrrigationMachine(String machineId, UpdateIrrigationMachineRequestDto dto) {
        IrrigationMachine irrigationMachine = irrigationMachineRepository.findById(machineId).orElseThrow(
                () -> new IrrigationMachineNotFoundException(machineId)
        );

        if (dto.kpis() != null) irrigationMachine.setKpis(dto.kpis());
        if (dto.description() != null) irrigationMachine.setDescription(dto.description());
        if (dto.name() != null) irrigationMachine.setName(dto.name());

        if (dto.zoneId() != null) {
            Zone zone = zoneService.findZone(dto.zoneId());
            irrigationMachine.setZone(zone);
        }

        return irrigationMachine;
    }

    public GetIrrigationMachineDetailsResponseDto getIrrigationMachineDetails(String machineId) {
        IrrigationMachine irrigationMachine = irrigationMachineRepository.findById(machineId).orElseThrow(
                () -> new IrrigationMachineNotFoundException(machineId)
        );

        return irrigationMachineMapper
                .irrigationMachineToGetIrrigationMachineDetailsResponseDtoMapper
                        (irrigationMachine);
    }

    public List<GetAllIrrigationMachinesResponseDto> getAllIrrigationMachines() {
        return irrigationMachineRepository.findAll()
                .stream()
                .map(irrigationMachineMapper::irrigationMachineToGetAllIrrigationMachinesResponseDtoMapper)
                .collect(Collectors.toList());
    }

    public void deleteIrrigationMachine(String machineId) {
        IrrigationMachine irrigationMachine = irrigationMachineRepository.findById(machineId).orElseThrow(
                () -> new IrrigationMachineNotFoundException(machineId)
        );

        irrigationMachineRepository.delete(irrigationMachine);
    }

}
