package com.chakrawaat.four.main;

import com.chakrawaat.four.bean.Vehicle;
import com.chakrawaat.four.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example4Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean(Vehicle.class);
        System.out.println("Primary bean: "+veh.getName());
    }
}
