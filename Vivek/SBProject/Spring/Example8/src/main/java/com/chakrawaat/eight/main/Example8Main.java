package com.chakrawaat.eight.main;

import com.chakrawaat.eight.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example8Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans.xml");
        var veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle : "+veh.getName());
    }
}
