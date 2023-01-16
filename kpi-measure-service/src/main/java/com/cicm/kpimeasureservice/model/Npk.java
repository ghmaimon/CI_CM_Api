package com.cicm.kpimeasureservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Npk {

    private Long ec;
    private Float nitrogen;
    private Float pH;
    private Float potassium;
}
