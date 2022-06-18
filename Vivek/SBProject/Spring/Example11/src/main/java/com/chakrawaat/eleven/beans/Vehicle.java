package com.chakrawaat.eleven.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name = "Honda City";

    public Vehicle() {
        System.out.println("Vehicle bean is created from the Spring Context!");
    }

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
