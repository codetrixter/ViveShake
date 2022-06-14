package com.chakrawaat.seven.main;

import com.chakrawaat.seven.beans.Vehicle;
import com.chakrawaat.seven.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7Main {
    public static void main(String[] args) {

        //create an object of Vehicle named volkswagon and it's supplier
        final var volksVehicle = new Vehicle();
        volksVehicle.setName("Volkswagon");
        Supplier<Vehicle> volksSupplier = ()-> volksVehicle;

        //create an object of Vehicle named audi and it's supplier
        Supplier<Vehicle> audiSupplier = () -> {
            var veh = new Vehicle();
            veh.setName("Audi");
            return veh;
        };

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Random random = new Random();
        int num = random.nextInt(10);
        System.out.println("num: "+num);
        Vehicle vVehicle = null;
        Vehicle audiVehicle = null;

        //if num is even create beans in Spring Context of volks else of audi.
        if(num % 2 == 0) {
            context.registerBean("volkswagen", Vehicle.class, volksSupplier);
        } else {
            context.registerBean("audiBean", Vehicle.class, audiSupplier);
        }

        //try to get the both beans
        try {
            vVehicle = context.getBean("volkswagen", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating volkswagen bean");
        }

        try{
            audiVehicle = context.getBean("audiBean", Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating audi bean");
        }

        if(vVehicle != null) {
            System.out.println("Programming vehicle name from spring context is : "+vVehicle.getName());
        } else {
            System.out.println("Programming vehicle name from spring context is : "+audiVehicle.getName());
        }
    }
}
