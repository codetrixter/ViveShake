package com.chakrawaat.ten.config;

import com.chakrawaat.ten.beans.Person;
import com.chakrawaat.ten.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Toyota");
        return  veh;
    }

    @Bean
    Person person(Vehicle vehicle) {
        var person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle);
        return person;
    }
}
