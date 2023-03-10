package com.cicm.zonesservice.mapper;

import com.cicm.zonesservice.dto.request.CreatePlantRequestDto;
import com.cicm.zonesservice.dto.response.GetAllPlantsResponseDto;
import com.cicm.zonesservice.dto.response.GetPlantDetailsResponseDto;
import com.cicm.zonesservice.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PlantMapper {
    @Mapping(target = "waterThreshold.lowerBound", source = "lowerWaterThreshold")
    @Mapping(target = "waterThreshold.upperBound", source = "upperWaterThreshold")
    Plant createPlantRequestDtoToPlantMapper(CreatePlantRequestDto dto);
    GetPlantDetailsResponseDto plantToGetPlantDetailsResponseDtoMapper(Plant plant);
    GetAllPlantsResponseDto plantToGetAllPlantsResponseDtoMapper(Plant plant);
}
