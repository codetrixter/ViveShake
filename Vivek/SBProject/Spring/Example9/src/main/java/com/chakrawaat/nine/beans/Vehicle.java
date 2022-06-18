package com.chakrawaat.nine.beans;

public class Vehicle {

    String name;

    public Vehicle () {
        System.out.println("Vehicle bean is created by Spring Context");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello from the Vehicle bean.");
    }

    public String toString() {
        return getName();
    }
}
