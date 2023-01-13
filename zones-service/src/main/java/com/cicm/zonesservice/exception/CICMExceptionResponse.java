package com.cicm.zonesservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class CICMExceptionResponse {
    private String message;
    private String contextPath;
    private Instant timestamp;
}
