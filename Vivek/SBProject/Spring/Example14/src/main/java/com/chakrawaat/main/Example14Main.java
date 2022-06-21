package com.chakrawaat.main;

import com.chakrawaat.beans.services.VehicleServices;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example14Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehServices1 = context.getBean(VehicleServices.class);
        var vehServices2 = context.getBean("vehicleServices", VehicleServices.class);

        System.out.println("vehServices1: hashcode() = "+vehServices1.hashCode());
        System.out.println("vehServices2: hashcode() = "+vehServices2.hashCode());

        if(vehServices1 == vehServices2)
            System.out.println("Both beans of VehicleServices are same!");
    }
}
