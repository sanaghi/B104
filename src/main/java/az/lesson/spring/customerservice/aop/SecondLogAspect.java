package az.lesson.spring.customerservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableAspectJAutoProxy
@Aspect
@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecondLogAspect {

    private  static  final  Logger  LOGGER = LoggerFactory.getLogger("alma ");

//    @Around("execution(* az.lesson.spring.customerservice.service.*.*(..))")
//    public Object   alma(ProceedingJoinPoint joinPoint) throws Throwable {
//        String methodName =
//        joinPoint.getSignature().getName();
//        Object [] arguments = joinPoint.getArgs();
//
//        LOGGER.info("Method " + methodName +
//                " with parameters " + Arrays.asList(arguments) +
//                        " will execute");
//        long id = 5;
//        Object [] argumentsProxy = {id};
//        Object returnedByMethod =   joinPoint.proceed(argumentsProxy);
//
//        LOGGER.info("Method executed and returned " + returnedByMethod);
//
//        return returnedByMethod;
//    }

    @Before("execution(* az.lesson.spring.customerservice.service.*.*(..))")
    public void  log() {
        LOGGER.info("SecondLogAspect   @Before(execution ");

    }
}
