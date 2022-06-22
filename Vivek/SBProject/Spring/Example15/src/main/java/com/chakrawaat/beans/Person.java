package com.chakrawaat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value="personBean")
@Lazy
public class Person {
    private String name = "Vivek";
    private final Vehicle vehicle;

    @Autowired
    public Person(Vehicle vehicle) {
        System.out.println("Person bean is created by Spring Context!");
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
