package by.oleg.service.configuration;

import by.oleg.service.calculator.engine.CalculatorEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorEngineConfiguration {

    @Bean
    CalculatorEngine calculatorEngine() {
        return new CalculatorEngine();
    }
}
