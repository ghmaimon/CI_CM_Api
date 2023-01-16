package com.cicm.zonesservice.controllerAdvice;

import com.cicm.zonesservice.exception.CICMException;
import com.cicm.zonesservice.exception.CICMExceptionResponse;
import com.cicm.zonesservice.exception.PlantNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Objects;

@RestController
@ControllerAdvice
public class PlantControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlantNotFoundException.class)
    public ResponseEntity<CICMExceptionResponse> handlePlantNotFoundException(
            PlantNotFoundException exception,
            WebRequest request
    ) {
        return ResponseEntity.status(404)
                .body(
                        new CICMExceptionResponse(
                                exception.getMessage(),
                                request.getContextPath(),
                                Instant.now()
                        )
                );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        return ResponseEntity.status(status)
                .body(
                        new CICMExceptionResponse(
                                Objects.requireNonNull(ex.getFieldError()).getDefaultMessage(),
                                request.getContextPath(),
                                Instant.now()
                        )
                );
    }

    @ExceptionHandler(CICMException.class)
    public ResponseEntity<CICMExceptionResponse> handleCICMException(
            CICMException exception,
            WebRequest request
    ) {
        return ResponseEntity.status(500)
                .body(
                        new CICMExceptionResponse(
                                exception.getMessage(),
                                request.getContextPath(),
                                Instant.now()
                        )
                );
    }
}
