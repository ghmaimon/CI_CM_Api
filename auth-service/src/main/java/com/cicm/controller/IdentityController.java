package com.cicm.controller;

import com.cicm.dto.UserDTO;
import com.cicm.service.IdentityService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class IdentityController {

    private final IdentityService identityService;

    @Post
    @Secured(SecurityRule.IS_ANONYMOUS)
    public void signUp(@Body @Valid UserDTO userDTO) {
        log.info("Sign up");
        identityService.signUp(userDTO);
    }
}
