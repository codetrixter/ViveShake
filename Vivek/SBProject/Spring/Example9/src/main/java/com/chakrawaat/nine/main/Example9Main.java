package com.chakrawaat.nine.main;

import com.chakrawaat.nine.beans.Person;
import com.chakrawaat.nine.beans.Vehicle;
import com.chakrawaat.nine.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example9Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        Vehicle vehicle = context.getBean(Vehicle.class);

        System.out.println("Person name from the Spring Context is: "+person.getName());
        System.out.println("Vehicle name from the Spring Context is: "+vehicle.getName());

        System.out.println("Vehicle that Person own is: "+person.getVehicle());
    }
}
