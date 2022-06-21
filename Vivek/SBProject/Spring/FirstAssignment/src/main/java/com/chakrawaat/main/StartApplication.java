package com.chakrawaat.main;

import com.chakrawaat.beans.Person;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var person = context.getBean(Person.class);
        System.out.println("Name of the driver: "+person.getName());
        System.out.println("Vehicle own by "+person.getName()+": "+person.getVehicle());
        person.moveCar();
        person.makeSpeakerSound();

    }
}
