package by.oleg.service.configuration;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/addition/**")
                        .and()
                        .method("GET")
                        .uri("http://localhost:9005/addition/**"))
                .route(r -> r.path("/addition/**")
                        .and()
                        .method("GET")
                        .uri("http://localhost:9006/addition/**"))
                .route(r -> r.path("/division/**")
                        .and()
                        .method("GET")
                        .uri("http://localhost:8091/divisions/**"))
                .route(r -> r.path("/multiplication/**")
                        .and()
                        .method("GET")
                        .uri("http://localhost:8092/multiplication/**"))
                .route(r -> r.path("/subtract/**")
                        .and()
                        .method("GET")
                        .uri("http://localhost:8093/subtract/**"))
                .build();
    }
}
