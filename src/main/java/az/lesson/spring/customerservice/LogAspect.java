package az.lesson.spring.customerservice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Before("execution(public * az.lesson.spring.customerservice.controller.CustomerController.getAllCustomer())")
    public void log(){
        System.out.println("getAllCustomer executed");
    }

    @AfterReturning("execution(public * az.lesson.spring.customerservice.controller.CustomerController.getAllCustomer())")
    public void logReturning(){
        System.out.println("getAllCustomer returned ");
    }
    @AfterThrowing("execution(public * az.lesson.spring.customerservice.controller.CustomerController.getAllCustomer())")
    public void logThrowing(){
        System.out.println(" insident happens ");
    }
}
