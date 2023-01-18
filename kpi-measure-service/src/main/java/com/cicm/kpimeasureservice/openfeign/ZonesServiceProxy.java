package com.cicm.kpimeasureservice.openfeign;

import com.cicm.kpimeasureservice.dto.GetPlantDetailsResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", contextId = "kpi-measures-service")
public interface ZonesServiceProxy {
    @GetMapping("/api/plants/sensor-id/{sensorId}")
    ResponseEntity<GetPlantDetailsResponseDto> getPlantWithSensorId(
            @PathVariable("sensorId") String sensorId
    );
}
