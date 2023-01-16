package com.cicm.kpimeasureservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class solarRadiation {

    private Float photosyntheticallyActiveRadiation;
    private Float shortwave;
    private Float uv;
}
