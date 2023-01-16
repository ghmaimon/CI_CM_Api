package com.cicm.zonesservice.service;

import com.cicm.zonesservice.dto.request.CreateSensorRequestDto;
import com.cicm.zonesservice.dto.request.UpdateSensorRequestDto;
import com.cicm.zonesservice.dto.response.GetAllSensorsResponseDto;
import com.cicm.zonesservice.dto.response.GetSensorDetailsResponseDto;
import com.cicm.zonesservice.model.Sensor;

import java.util.List;

public interface SensorService {
    Sensor createSensor(CreateSensorRequestDto dto);
    Sensor updateSensor(String sensorId, UpdateSensorRequestDto dto);
    GetSensorDetailsResponseDto getSensorDetails(String sensorId);
    List<GetAllSensorsResponseDto> getAllSensors();
    void deleteSensor(String sensorId);
    Sensor findSensor(String sensorId);
}
