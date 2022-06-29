package com.chakrawaat.main;

import com.chakrawaat.beans.Vehicle;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example17Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean(Vehicle.class);
        boolean isVehicleStarted = true;
        veh.rotate(isVehicleStarted);
        veh.playMusic(isVehicleStarted);
        veh.stopVehicle(isVehicleStarted);
    }
}
