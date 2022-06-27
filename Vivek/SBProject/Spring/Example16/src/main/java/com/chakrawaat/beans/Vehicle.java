package com.chakrawaat.beans;

import com.chakrawaat.beans.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;

@Component
public class Vehicle {
    private String name = "FZS";
    private VehicleServices vehicleServices;

    @Autowired
    public Vehicle(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
        System.out.println("Vehicle bean is created by Spring Framework!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
