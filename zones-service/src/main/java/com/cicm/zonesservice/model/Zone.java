package com.cicm.zonesservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;
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
    private List<ZoneKpiMeasure> measures;
}
