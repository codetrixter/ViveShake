package com.chakrawaat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name = "Honda City";
    private final VehicleServices services;

    @Autowired
    public Vehicle(VehicleServices vehicleServices) {
        services = vehicleServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleServices getServices() {
        return services;
    }

    @Override
    public String toString() {
        return getName();
    }
}
