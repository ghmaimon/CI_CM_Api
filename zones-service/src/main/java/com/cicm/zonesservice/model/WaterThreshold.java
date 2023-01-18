package com.cicm.zonesservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class WaterThreshold {
    private Float lowerBound;
    private Float upperBound;
}
