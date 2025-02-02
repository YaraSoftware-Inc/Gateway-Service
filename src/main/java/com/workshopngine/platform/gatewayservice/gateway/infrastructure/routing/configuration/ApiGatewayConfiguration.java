package com.workshopngine.platform.gatewayservice.gateway.infrastructure.routing.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route to the file-management service
                .route(r -> r.path("/files/**")
                        .uri("lb://file-management"))

                .route(r -> r.path("/file-management/v3/api-docs", "/file-management/v3/api-docs/**")
                        .uri("lb://file-management"))

                // Route to the service-operations service
                .route(r -> r.path("/diagnostics/**", "/work-orders/**")
                        .uri("lb://service-operations"))

                .route(r -> r.path("/service-operations/v3/api-docs", "/service-operations/v3/api-docs/**")
                        .uri("lb://service-operations"))

                // Route to the workshop-management service
                .route(r -> r.path("/workshops/**")
                        .uri("lb://workshop-management"))

                .route(r -> r.path("/workshops-management/v3/api-docs", "/workshops-management/v3/api-docs/**")
                        .uri("lb://workshop-management"))

                // Route to the scheduling-management service
                .route(r -> r.path("/appointments/**")
                        .uri("lb://scheduling-management"))

                .route(r -> r.path("/scheduling-management/v3/api-docs", "/scheduling-management/v3/api-docs/**")
                        .uri("lb://scheduling-management"))

                // Route to the staff-management service
                .route(r -> r.path("/mechanics/**")
                        .uri("lb://staff-management"))

                .route(r -> r.path("/staff-management/v3/api-docs", "/staff-management/v3/api-docs/**")
                        .uri("lb://staff-management"))
                .build();
    }
}
