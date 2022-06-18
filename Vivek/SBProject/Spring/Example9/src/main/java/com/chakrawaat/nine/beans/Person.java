package com.chakrawaat.nine.beans;

public class Person {
    String name;
    Vehicle vehicle;

    public Person () {
        System.out.println("Person is created by Spring Context!");
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

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void printHello() {
        System.out.println("Hello World ! from Person bean.");
    }
}

