package com.chakrawaat.ten.beans;

public class Vehicle {
    private String name;

    public Vehicle() {
        System.out.println("Vehicle bean is created by Spring Context!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }

}
