package com.codegym.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {
    private static int count = 1;
    @AfterReturning(pointcut = "execution(* com.codegym.controller.BookController.*(..))")
    public static void proccessing(JoinPoint joinpoint){
        String method = joinpoint.getSignature().getName();
        int countBook= count++;
        System.err.println(method +", "+countBook);
    }
}
