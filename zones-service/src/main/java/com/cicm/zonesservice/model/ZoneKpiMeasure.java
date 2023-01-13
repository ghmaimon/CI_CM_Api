package com.cicm.zonesservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Document("zone-kpi-measure")
@Data
public class ZoneKpiMeasure {

    @Id
    private String id;
    @NotNull
    private Instant measureTime;
    @ReadOnlyProperty
    @DocumentReference
    @NotNull
    private Zone zone;
}
