package com.cicm.zonesservice.mapper;

import com.cicm.zonesservice.dto.request.CreateIrrigationMachineRequestDto;
import com.cicm.zonesservice.dto.response.GetAllIrrigationMachinesResponseDto;
import com.cicm.zonesservice.dto.response.GetIrrigationMachineDetailsResponseDto;
import com.cicm.zonesservice.model.IrrigationMachine;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface IrrigationMachineMapper {
    IrrigationMachine createIrrigationMachineRequestDtoToIrrigationMachineMapper(CreateIrrigationMachineRequestDto dto);
    GetIrrigationMachineDetailsResponseDto irrigationMachineToGetIrrigationMachineDetailsResponseDtoMapper(IrrigationMachine machine);
    GetAllIrrigationMachinesResponseDto irrigationMachineToGetAllIrrigationMachinesResponseDtoMapper(IrrigationMachine machine);
}
