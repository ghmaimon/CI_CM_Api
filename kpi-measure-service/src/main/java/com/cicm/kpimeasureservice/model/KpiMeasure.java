package com.cicm.kpimeasureservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
}
