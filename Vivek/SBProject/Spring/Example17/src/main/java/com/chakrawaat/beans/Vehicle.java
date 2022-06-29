package com.chakrawaat.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    public Vehicle() {
        System.out.println("Vehicle created by Spring Context!!!!");
    }

    private String name = "Yadav";

    public String getName() {
        return name;
    }

    public void rotate(boolean isVehicleStarted) {
        if (isVehicleStarted)
            System.out.println("||||||||Vehicle started !!!!!!!!!!!!!!!!!!!!!");
        else
            System.out.println("Vehicle is not yet started");
    }

    public void playMusic(boolean isVehicleStarted) {
        if (isVehicleStarted)
            System.out.println("||||||||Music is playing!!!!!!!!!!!!!!!!!!!!!");
        else
            System.out.println("Vehicle is not yet started");
    }

    public void stopVehicle(boolean isVehicleStarted) {
        if (isVehicleStarted)
            System.out.println("||||||||Vehicle stopped !!!!!!!!!!!!!!!!!!!!");
        else
            System.out.println("Vehicle is not yet started");
    }
}
