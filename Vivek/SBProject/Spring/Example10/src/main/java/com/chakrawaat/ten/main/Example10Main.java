package com.chakrawaat.ten.main;

import com.chakrawaat.ten.beans.Person;
import com.chakrawaat.ten.beans.Vehicle;
import com.chakrawaat.ten.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example10Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var person = context.getBean(Person.class);
        var vehicle = context.getBean(Vehicle.class);
        System.out.println("Person name from the Context is: "+person.getName());
        System.out.println("Vehicle name from the Context is: "+vehicle.getName());
        System.out.println("Vehicle that Person own is: "+person.getVehicle());
    }
}
