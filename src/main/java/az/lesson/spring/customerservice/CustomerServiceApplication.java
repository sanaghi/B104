package az.lesson.spring.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CustomerServiceApplication.class, args);
    }

}
