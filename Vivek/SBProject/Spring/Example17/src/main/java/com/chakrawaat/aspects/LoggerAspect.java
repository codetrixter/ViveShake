package com.chakrawaat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    // @Around("execution(* com.chakrawaat.beans.Vehicle.rotate(..))")
    @Around("execution(* com.chakrawaat.beans.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method: "+timeElapsed);
        logger.info(joinPoint.getSignature().toString()+ "method execution end");
    }

    @Around("@annotation(com.chakrawaat.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.toString() + "||......... annotation method started ................");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Total time took in execution: "+timeElapsed);
        logger.info(joinPoint.getSignature().toString() + "........method execution end..................||");
    }

    @AfterThrowing(value = "execution(* com.chakrawaat.beans.*.*(..))", throwing = "exec")
    public void logException(JoinPoint joinPoint, Exception exec) {
        logger.log(Level.SEVERE, joinPoint.getSignature()+ " An exception thrown with the help of"+
                " @AfterThrowing which happend due to : "+exec.getMessage());
    }

    @AfterReturning(value="execution(* com.chakrawaat.beans.*.*(..))", returning = "val")
    public void logStatus(JoinPoint joinPoint, Object val) {
        logger.log(Level.INFO, joinPoint.getSignature()+" Method successfully processed with the status "+
                val.toString());
    }
}
