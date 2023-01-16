package com.cicm.zonesservice.service;

import com.cicm.zonesservice.dto.request.CreateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.request.UpdateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.response.GetAllIrrigationMachinesResponseDto;
import com.cicm.zonesservice.dto.response.GetIrrigationMachineDetailsResponseDto;
import com.cicm.zonesservice.model.IrrigationMachine;

import java.util.List;

public interface IrrigationMachineService {
    IrrigationMachine createIrrigationMachine(CreateIrrigationMachineRequestDto dto);
    IrrigationMachine updateIrrigationMachine(String machineId, UpdateIrrigationMachineRequestDto dto);
    GetIrrigationMachineDetailsResponseDto getIrrigationMachineDetails(String machineId);
    List<GetAllIrrigationMachinesResponseDto> getAllIrrigationMachines();
    void deleteIrrigationMachine(String machineId);
}
