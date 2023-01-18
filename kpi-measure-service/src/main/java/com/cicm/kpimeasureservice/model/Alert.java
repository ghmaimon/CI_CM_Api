package com.cicm.kpimeasureservice.model;

import com.cicm.kpimeasureservice.enumeration.AlertType;
import java.time.Instant;

public record Alert(
        AlertType type,
        String message,
        Instant timestamp,
        String zoneId
) {
    public static final Long WATER_UPPER_THRESHOLD = 40L;
    public static final Long WATER_LOWER_THRESHOLD = 5L;
}
