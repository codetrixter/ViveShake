package com.chakrawaat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class VehicleStartCheckAspect {

    private Logger logger = Logger.getLogger(VehicleStartCheckAspect.class.getName());

    @Before("execution(* com.chakrawaat.beans.*.*(..)) && args(isVehicleStarted,..)")
    public void checkVehicleStarted(JoinPoint joinPoint, boolean isVehicleStarted) throws Throwable {
        if(!isVehicleStarted) {
            throw new RuntimeException("Vehicle not started....");
        }
    }
}
