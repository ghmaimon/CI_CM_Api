package com.cicm.model;

import io.micronaut.data.annotation.MappedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@MappedEntity
@Setter
@Getter
@NoArgsConstructor
public class Identity {
    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String fullName;
    @Email
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Identity(String username, String fullName, String email, String password, LocalDate dateOfBirth,Role role) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
}
