package com.vivek.eazybytes.main;

import com.vivek.eazybytes.beans.Vehicle;
import com.vivek.eazybytes.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //var veh = context.getBean(Vehicle.class); - this will give exception NoUniqueBeanException
        //so go with below way
        var veh = context.getBean("vehicle1", Vehicle.class);
        System.out.println("Vehicle 1: "+veh.getName());

        var veh2 = context.getBean("vehicle2", Vehicle.class);
        System.out.println("Vehicle 2: "+veh2.getName());

        var veh3 = context.getBean("vehicle3", Vehicle.class);
        System.out.println("Vehicle 3: "+veh3.getName());
    }
}
