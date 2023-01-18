package com.cicm.zonesservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document("irrigation-machine")
public class IrrigationMachine {

    @Id
    private String id;
    private String name;
    private String description;
    @DocumentReference(lazy = true)
    private Zone zone;
}
