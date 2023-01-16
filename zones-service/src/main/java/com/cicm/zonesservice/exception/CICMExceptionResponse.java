package com.cicm.zonesservice.exception;

import java.time.Instant;

public record CICMExceptionResponse(
        String message,
        String contextPath,
        Instant timestamp
) {
}
