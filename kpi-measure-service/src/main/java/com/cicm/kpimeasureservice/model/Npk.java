package com.cicm.kpimeasureservice.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Npk {
    private Long ec;
    private Float nitrogen;
    @JsonAlias("pH")
    private Float pH;
    private Float potassium;
}
