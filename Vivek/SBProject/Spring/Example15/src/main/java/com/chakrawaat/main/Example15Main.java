package com.chakrawaat.main;

import com.chakrawaat.beans.Person;
import com.chakrawaat.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example15Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("First statement in main method!");
        var person = context.getBean(Person.class);
        System.out.println("Last statement in main method");
    }
    /*       output
    Vehicle Bean is created by Spring: Eager Initialization
    First statement in main method!
    Person bean is created by Spring Context!
    Last statement in main method
     */
}
