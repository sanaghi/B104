package az.lesson.spring.customerservice;

import eye2web.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CustomerServiceApplication.class, args);
    }

}
