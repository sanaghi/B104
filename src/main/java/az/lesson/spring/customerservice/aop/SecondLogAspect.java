package az.lesson.spring.customerservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@EnableAspectJAutoProxy
@Aspect
@Component
public class SecondLogAspect {

    private  static  final  Logger  LOGGER = LoggerFactory.getLogger(SecondLogAspect.class);

    @Around("execution(* az.lesson.spring.customerservice.service.*.*(..))")
    public Object   log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName =
        joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        LOGGER.info("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                        " will execute");

        Object returnedByMethod =   joinPoint.proceed();

        LOGGER.info("Method executed and returned " + returnedByMethod);

        return returnedByMethod;
    }

    @Before("execution(* az.lesson.spring.customerservice.service.*.*(..))")
    public void  log() {
        LOGGER.info("SecondLogAspect   @Before(execution ");

    }
}
