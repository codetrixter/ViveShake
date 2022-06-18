package com.chakrawaat.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name = "Lamborghini";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return getName();
    }
}
