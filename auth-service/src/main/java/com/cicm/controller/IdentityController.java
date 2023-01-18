package com.cicm.controller;

import com.cicm.dto.UserDTO;
import com.cicm.service.IdentityService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Controller("/api/auth")
@Slf4j
@RequiredArgsConstructor
@Secured({"FARM_ADMIN"})
public class IdentityController {

    private final IdentityService identityService;

    @Post("/create")
    public UserDTO createUser(@Body @Valid UserDTO userDTO) {
        return identityService.createUser(userDTO);
    }
}
