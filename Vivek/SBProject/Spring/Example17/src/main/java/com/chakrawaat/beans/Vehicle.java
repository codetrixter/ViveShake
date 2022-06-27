package com.chakrawaat.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    public Vehicle () {
        System.out.println("Vehicle created by Spring Context!!!!");
    }

    private String name = "Yadav";

    public String getName() {
        return name;
    }

    public void rotate() {
        System.out.println("||||||||Vehicle started !!!!!!!!!!!!!!!!!!!!!");
    }
}
