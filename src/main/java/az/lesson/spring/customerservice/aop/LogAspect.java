package az.lesson.spring.customerservice.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    private  static  final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("execution(* az.lesson.spring.customerservice.service.*.*(..))")
    public void logPointcut(){
        LOGGER.info("LogAspect  before advice");
    }

    @Before("logPointcut()")
    public void logPointCutCalled(){

    }
    @After("logPointcut()")
    public void logPointCutCalledAfter(){

    }


    @AfterReturning("execution(public * az.lesson.spring.customerservice.controller.CustomerController.getAllCustomer())")
    public void logReturning(){
        System.out.println("getAllCustomer returned ");
    }

    @AfterThrowing("execution(public * az.lesson.spring.customerservice.controller.CustomerController.getAllCustomer())")
    public void logThrowing(){
        LOGGER.info("Aspect execution AfterThrowing  ");
    }

    @After("execution(public * az.lesson.spring.customerservice.controller.CustomerController.getAllCustomer())")
    public void logAfter(){
        LOGGER.info("Aspect execution After");
    }
}
