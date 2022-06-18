package com.chakrawaat.eleven.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Vivek";
    @Autowired
    private Vehicle vehicle;

    public Person() {
        System.out.println("Person bean is created from Spring Context");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
