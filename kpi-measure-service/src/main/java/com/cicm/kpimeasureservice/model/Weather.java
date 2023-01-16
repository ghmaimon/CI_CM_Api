package com.cicm.kpimeasureservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Weather {

    private Float airPressure;
    private Float humidity;
    private Long precipitation;
    private Long temperature;
    private Long windDirection;
    private Long windSpeed;
}
