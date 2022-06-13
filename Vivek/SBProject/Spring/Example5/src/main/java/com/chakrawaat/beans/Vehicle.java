package com.chakrawaat.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printHello() {
        System.out.println("Printing hello from Vehicle bean!");
    }
}
