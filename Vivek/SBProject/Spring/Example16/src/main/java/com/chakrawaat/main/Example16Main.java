package com.chakrawaat.main;

import com.chakrawaat.beans.services.VehicleServices;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example16Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehServices1 = context.getBean(VehicleServices.class);
        var vehServices2 = context.getBean("vehicleServices", VehicleServices.class);
        System.out.println("vehServices1 hascode: "+vehServices1.hashCode());
        System.out.println("vehServices2 hascode: "+vehServices2.hashCode());

        if(vehServices1.hashCode() == vehServices2.hashCode())
            System.out.println("Singleton Scope");
        else
            System.out.println("Prototype Scope");
    }
}
