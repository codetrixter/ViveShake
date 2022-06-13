package com.example1.config;

import com.example1.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Bean
    String hello() {
        return "Hello World!";
    }

    @Bean
    Integer number() {
        return 16;
    }
}
