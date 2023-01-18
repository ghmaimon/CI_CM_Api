package com.cicm.dto;

import com.cicm.model.Role;
import io.micronaut.core.annotation.Introspected;

import java.time.LocalDate;

@Introspected
public record UserDTO(
        String fullName,
        String username,
        String email,
        String password,
        LocalDate dateOfBirth,
        Role role
) {
}
