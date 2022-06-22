package com.chakrawaat.beans.services;

import com.chakrawaat.beans.Vehicle;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices {

    public VehicleServices(){
        System.out.println("VehicleServices Bean is created by Spring Framework!");
    }
}
