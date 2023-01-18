package com.cicm.zonesservice.service.serviceImpl;

import com.cicm.zonesservice.dto.request.CreateSensorRequestDto;
import com.cicm.zonesservice.dto.request.UpdateSensorRequestDto;
import com.cicm.zonesservice.dto.response.GetAllSensorsResponseDto;
import com.cicm.zonesservice.dto.response.GetSensorDetailsResponseDto;
import com.cicm.zonesservice.exception.SensorNotFoundException;
import com.cicm.zonesservice.mapper.SensorMapper;
import com.cicm.zonesservice.model.Sensor;
import com.cicm.zonesservice.model.Zone;
import com.cicm.zonesservice.repository.SensorRepository;
import com.cicm.zonesservice.service.SensorService;
import com.cicm.zonesservice.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Primary
@Service
public class SensorServiceImpl implements SensorService {

    private SensorRepository sensorRepository;
    private SensorMapper sensorMapper;
    private ZoneService zoneService;

    public Sensor createSensor(CreateSensorRequestDto dto) {
        Sensor sensor =
                sensorMapper.createSensorRequestDtoToSensorMapper(dto);
        sensor.setZone(
                zoneService.findZone(dto.zoneId())
        );

        return sensorRepository.save(sensor);
    }

    public Sensor updateSensor(String sensorId, UpdateSensorRequestDto dto) {
        Sensor sensor = findSensor(sensorId);

        if (dto.name() != null) sensor.setName(dto.name());
        if (dto.description() != null) sensor.setDescription(dto.description());
            if (dto.zoneId() != null) {
            Zone zone = zoneService.findZone(dto.zoneId());
            sensor.setZone(zone);
        }

        return sensor;
    }

    public GetSensorDetailsResponseDto getSensorDetails(String sensorId) {
        return sensorMapper.sensorToGetSensorDetailsResponseDtoMapper(
                findSensor(sensorId)
        );
    }

    public List<GetAllSensorsResponseDto> getAllSensors() {
        return sensorRepository.findAll()
                .stream()
                .map(sensorMapper::sensorToGetAllSensorsResponseDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Sensor findSensor(String sensorId) {
        return sensorRepository.findById(sensorId).orElseThrow(
                () -> new SensorNotFoundException(sensorId)
        );
    }

    public void deleteSensor(String sensorId) {
        sensorRepository.delete(
                findSensor(sensorId)
        );
    }

}
