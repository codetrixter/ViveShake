package com.example1;

import com.example1.config.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1Main {

    public static void main(String[] args) {
        var veh = new Vehicle();
        veh.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is: "+veh.getName());


        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var vehBean = context.getBean(Vehicle.class);
        System.out.println("Vehicle bean: "+vehBean.getName());

        var hello = context.getBean(String.class);
        System.out.println("Hello from bean : "+hello);

        var num = context.getBean(Integer.class);
        System.out.println("Number from bean : "+num);
    }
}
