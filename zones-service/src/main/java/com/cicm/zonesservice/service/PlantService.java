package com.cicm.zonesservice.service;


import com.cicm.zonesservice.dto.request.CreatePlantRequestDto;
import com.cicm.zonesservice.dto.request.UpdatePlantRequestDto;
import com.cicm.zonesservice.dto.response.GetAllPlantsResponseDto;
import com.cicm.zonesservice.dto.response.GetPlantDetailsResponseDto;
import com.cicm.zonesservice.model.Plant;

import java.util.List;

public interface PlantService {
    Plant createPlant(CreatePlantRequestDto dto);
    Plant updatePlant(String plantId, UpdatePlantRequestDto dto);
    GetPlantDetailsResponseDto getPlantDetails(String plantId);
    List<GetAllPlantsResponseDto> getAllPlants();
    void deletePlant(String plantId);
}
