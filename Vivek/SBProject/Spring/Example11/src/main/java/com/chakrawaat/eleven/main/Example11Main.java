package com.chakrawaat.eleven.main;

import com.chakrawaat.eleven.beans.Person;
import com.chakrawaat.eleven.beans.Vehicle;
import com.chakrawaat.eleven.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example11Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var person = context.getBean(Person.class);
        var vehicle = context.getBean(Vehicle.class);

        System.out.println("Person name from the Spring context is : "+person.getName());
        System.out.println("Vehicle name from the spring context is : "+vehicle.getName());
        System.out.println("Vehicle that person Vivek owns is: "+person.getVehicle());
    }
}
