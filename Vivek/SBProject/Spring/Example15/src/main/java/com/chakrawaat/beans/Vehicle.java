package com.chakrawaat.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name = "Honda";

    public Vehicle() {
        System.out.println("Vehicle Bean is created by Spring: Eager Initialization");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
