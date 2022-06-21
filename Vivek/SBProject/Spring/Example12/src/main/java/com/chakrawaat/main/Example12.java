package com.chakrawaat.main;

import com.chakrawaat.beans.Person;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example12 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var person = context.getBean(Person.class);
        System.out.println("Person name from Spring Context is: "+ person.getName());
        System.out.println("Vehicle that person own is: "+person.getVehicle());
    }
}
