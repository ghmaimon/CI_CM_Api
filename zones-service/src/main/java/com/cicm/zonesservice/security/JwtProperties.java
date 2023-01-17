package com.cicm.zonesservice.security;

import com.auth0.jwt.algorithms.Algorithm;

public class JwtProperties {
    public final static String SECRET = "s5v8y/A?D(G+KbPeShVmYq3t6w9z$C&E";
    public static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
}
