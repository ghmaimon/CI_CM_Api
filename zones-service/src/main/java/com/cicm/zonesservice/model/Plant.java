package com.cicm.zonesservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document("plant")
public class Plant {

    @Id
    private String id;
    private String name;
    private String description;
    @DocumentReference
    private List<Zone> zones;

}
