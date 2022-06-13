package com.chakrawaat.main;

import com.chakrawaat.beans.Vehicle;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example5Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicle = context.getBean(Vehicle.class);
        System.out.println("Name of the vehicle: "+vehicle.getName());
        vehicle.printHello();
    }
}
