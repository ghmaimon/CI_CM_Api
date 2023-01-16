package com.cicm.zonesservice.mapper;

import com.cicm.zonesservice.dto.request.CreateSensorRequestDto;
import com.cicm.zonesservice.dto.response.GetAllSensorsResponseDto;
import com.cicm.zonesservice.dto.response.GetSensorDetailsResponseDto;
import com.cicm.zonesservice.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SensorMapper {
    Sensor createSensorRequestDtoToSensorMapper(CreateSensorRequestDto dto);
    GetSensorDetailsResponseDto sensorToGetSensorDetailsResponseDtoMapper(Sensor sensor);
    GetAllSensorsResponseDto sensorToGetAllSensorsResponseDtoMapper(Sensor sensor);
}
