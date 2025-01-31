package com.preppy.jobpreparation.aspects;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect  // Mark this class as an Aspect
@Configuration  // Make it a Spring Bean
public class LoggingAspect {
    @PostConstruct
    void print(){
        logger.info("Aspect class initializd");
    }

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut expression: Apply this aspect to all methods in service package
    @Pointcut("execution(* package com.preppy.jobpreparation.service..*(..))")
    public void serviceMethods() {}

    // Around Advice: Measure execution time
    //@Around("serviceMethods()")
    @Around("execution(* package com.preppy.jobpreparation.service..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();  // Proceed with method execution
        long duration = System.currentTimeMillis() - start;

        logger.info("{} executed in {} ms", joinPoint.getSignature(), duration);
        return result;
    }
}

