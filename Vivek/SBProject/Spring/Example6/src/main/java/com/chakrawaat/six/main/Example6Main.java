package com.chakrawaat.six.main;

import com.chakrawaat.six.beans.Vehicle;
import com.chakrawaat.six.config.ProjectConifg;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example6Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConifg.class);
        var vehicle = context.getBean(Vehicle.class);
        System.out.println("Name of the vehicle after postConstruct: "+vehicle.getName());
        vehicle.printHello();
    }
}
