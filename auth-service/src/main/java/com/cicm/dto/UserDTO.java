package com.cicm.dto;

import java.time.LocalDate;

public record UserDTO(
        String fullName,
        String username,
        String email,
        String password,
        LocalDate dateOfBirth
) {
}
