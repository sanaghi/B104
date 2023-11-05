package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String alias;

    private  String cardNumberHolder;

    private  int expireMonth;
    private  int expireYear;
    private  int cvv;

//    @OneToMany
//    List<Customer> customers;
}
