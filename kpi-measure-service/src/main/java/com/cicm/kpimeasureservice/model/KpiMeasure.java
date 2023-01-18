package com.cicm.kpimeasureservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "kpi-measures")
public class KpiMeasure {
    @Id
    private String id;
    private Moisture moisture;
    private Npk npk;
    private solarRadiation solarRadiation;
    private Temperature temperature;
    private Weather weather;
    private Long timestamp;
    private Device device;
}
