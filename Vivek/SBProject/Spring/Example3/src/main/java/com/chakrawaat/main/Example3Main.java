package com.chakrawaat.main;

import com.chakrawaat.bean.Vehicle;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var veh1 = context.getBean("audiVehicle", Vehicle.class);
        System.out.println(veh1.getName());

        var veh2 = context.getBean("hondaVehicle", Vehicle.class);
        System.out.println(veh2.getName());

        var veh3 = context.getBean("ferrariVehicle", Vehicle.class);
        System.out.println(veh3.getName());
    }
}
