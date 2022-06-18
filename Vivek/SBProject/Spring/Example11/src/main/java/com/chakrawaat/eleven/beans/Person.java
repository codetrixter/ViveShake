package com.chakrawaat.eleven.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Vivek";

    /*similar thing can be achived by removeing @Autowired from here and moving to setVehicle() */
    /*@Autowired*/
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

    @Autowired
    public void setVehicle(Vehicle vehicle) {
        System.out.println("setVehicle() of person is called : "+vehicle);
        this.vehicle = vehicle;
    }
}
