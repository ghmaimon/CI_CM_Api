package com.cicm.kpimeasureservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Moisture {
    private Float conductivity;
    private Long soilMoisture;
    private Float soilWaterPotential;
    private Long volumetricWaterContent;
}
