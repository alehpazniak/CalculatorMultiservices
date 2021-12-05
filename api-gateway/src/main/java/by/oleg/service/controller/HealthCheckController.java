package by.oleg.service.controller;


import by.oleg.service.configuration.HealthCheckConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckConfiguration healthCheckConfiguration;

    @GetMapping("/health")
    public String healthCheck() {
        return "Gateway service UP";
    }
}
