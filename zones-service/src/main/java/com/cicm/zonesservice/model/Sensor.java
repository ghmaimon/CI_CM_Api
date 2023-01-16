package com.cicm.zonesservice.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Data
@Document("sensor")
public class Sensor {

    @Id
    private String id;
    @NotNull
    private Date orderDate;
    @NotNull
    private String name;
    private String description;
    @DocumentReference(lazy = true)
    private Zone zone;


}
