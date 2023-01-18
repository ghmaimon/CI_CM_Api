package com.cicm.gateway.configuration;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(zoneServiceRoute)
                .route(authServiceRoute)
                .build();
    }

    private final Function<PredicateSpec, Buildable<Route>> zoneServiceRoute =
            (PredicateSpec ps) -> ps
                    .path(
                            "/api/zones/**",
                            " /api/sensors/**",
                            " /api/irrigation-machines/**",
                            " /api/plants/**"
                    )
                    .uri("lb://zones-service");

    private final Function<PredicateSpec, Buildable<Route>> authServiceRoute =
            (PredicateSpec ps) -> ps
                    .path("/api/auth/**")
                    .uri("lb://auth-service");
}
