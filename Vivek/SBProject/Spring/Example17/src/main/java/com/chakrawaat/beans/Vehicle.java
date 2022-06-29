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

    public String rotate(boolean isVehicleStarted) {
        if (isVehicleStarted) return "||||||||Vehicle started !!!!!!!!!!!!!!!!!!!!!";
        else return "";
    }

    public String playMusic(boolean isVehicleStarted) {
        if (isVehicleStarted) return "||||||||Music is playing!!!!!!!!!!!!!!!!!!!!!";
        else return "";
    }

    public String stopVehicle(boolean isVehicleStarted) {
        if (isVehicleStarted)
            return "||||||||Vehicle stopped !!!!!!!!!!!!!!!!!!!!";
        else return "";
    }
}
