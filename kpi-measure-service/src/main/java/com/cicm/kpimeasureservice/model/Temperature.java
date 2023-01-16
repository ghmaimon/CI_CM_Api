package com.cicm.kpimeasureservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Temperature {

    private Long nonContactSurfaceTemperature;
    private Long soilTemperature;
}
