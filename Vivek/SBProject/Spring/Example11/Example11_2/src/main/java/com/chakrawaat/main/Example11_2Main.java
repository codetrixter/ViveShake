package com.chakrawaat.main;

import com.chakrawaat.beans.Person;
import com.chakrawaat.beans.Vehicle;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example11_2Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehilce = context.getBean(Vehicle.class);
        var person = context.getBean(Person.class);

        System.out.println("person from Spring Context is: "+person.getName());
        System.out.println("vehicle from Spring Context is: "+vehilce);

        System.out.println("Vehicle related to person is : "+person.getVehicle());
    }
}
