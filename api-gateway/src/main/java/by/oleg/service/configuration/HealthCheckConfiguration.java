package by.oleg.service.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "config.api-gateway.health")
public class HealthCheckConfiguration {

    private String MessageUp;
}
