package com.chakrawaat.main;

import com.chakrawaat.beans.Vehicle;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example17Main {

    public static void main(String[] args) throws Exception{
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean(Vehicle.class);
        boolean isVehicleStarted = true;
        System.out.println("rotate(): "+veh.rotate(isVehicleStarted));
        System.out.println("playMusic(): "+veh.playMusic(isVehicleStarted));
        System.out.println("stopVehicle(): "+veh.stopVehicle(isVehicleStarted));
    }
}
