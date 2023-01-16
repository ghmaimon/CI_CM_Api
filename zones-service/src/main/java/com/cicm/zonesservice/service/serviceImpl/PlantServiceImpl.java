package com.cicm.zonesservice.service.serviceImpl;

import com.cicm.zonesservice.dto.request.CreatePlantRequestDto;
import com.cicm.zonesservice.dto.request.UpdatePlantRequestDto;
import com.cicm.zonesservice.dto.response.GetAllPlantsResponseDto;
import com.cicm.zonesservice.dto.response.GetPlantDetailsResponseDto;
import com.cicm.zonesservice.exception.PlantNotFoundException;
import com.cicm.zonesservice.mapper.PlantMapper;
import com.cicm.zonesservice.model.Plant;
import com.cicm.zonesservice.repository.PlantRepository;
import com.cicm.zonesservice.service.PlantService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Primary
public class PlantServiceImpl implements PlantService {

    private PlantRepository plantRepository;
    private PlantMapper plantMapper;

    public Plant createPlant(CreatePlantRequestDto dto) {
        return plantRepository.save(
                plantMapper.createPlantRequestDtoToPlantMapper(dto)
        );
    }

    public Plant updatePlant(String plantId, UpdatePlantRequestDto dto) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(
                () -> new PlantNotFoundException(plantId)
        );

        if (dto.name() != null) plant.setName(dto.name());
        if (dto.description() != null) plant.setDescription(dto.description());

        return plant;
    }

    public GetPlantDetailsResponseDto getPlantDetails(String plantId) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(
                () -> new PlantNotFoundException(plantId)
        );

        return plantMapper.plantToGetPlantDetailsResponseDtoMapper(plant);
    }

    public List<GetAllPlantsResponseDto> getAllPlants() {
        return plantRepository.findAll()
                .stream()
                .map(plantMapper::plantToGetAllPlantsResponseDtoMapper)
                .collect(Collectors.toList());
    }

    public void deletePlant(String plantId) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(
                () -> new PlantNotFoundException(plantId)
        );

        plantRepository.delete(plant);
    }

}
