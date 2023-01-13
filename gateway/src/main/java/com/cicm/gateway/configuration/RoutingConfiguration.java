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
                .build();
    }

    private Function<PredicateSpec, Buildable<Route>> zoneServiceRoute =
            (PredicateSpec ps) -> ps
                    .path("/api/zones/**")
                    .uri("lb://zone-service");
}
