package com.cicm.zonesservice.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.List;

@Data
@Document("zone")
public class Zone {

    @Id
    private String id;
    private Long length; // in yards
    private Long width; // in yards
    @NotNull
    private Long size; // in hectares
    private String physicalLocation; // to use in Google Maps
    @DocumentReference
    private List<Sensor> sensors;
    @DocumentReference(lazy = true)
    private Plant plant;
    @DocumentReference
    private List<IrrigationMachine> irrigationMachines;
}
