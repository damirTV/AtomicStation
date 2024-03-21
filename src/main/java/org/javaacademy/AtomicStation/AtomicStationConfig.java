package org.javaacademy.AtomicStation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtomicStationConfig {
    @Bean
    public ReactorDepartment reactorDepartment() {
        return new ReactorDepartment();
    }

    @Bean
    public NuclearStation nuclearStation(ReactorDepartment reactorDepartment) {
        return new NuclearStation(reactorDepartment);
    }
}
