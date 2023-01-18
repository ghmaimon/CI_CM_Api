package com.cicm.kpimeasureservice.model;

import lombok.Data;

public record Device (
    String sensorId,
    String physicalLocation
){}
