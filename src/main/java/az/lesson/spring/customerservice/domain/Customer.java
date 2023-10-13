package az.lesson.spring.customerservice.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String surName;
    private  double debt;

    public Customer(Long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public Customer() {
    }

    public Customer(Long id, String name, String surName, double debt) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.debt = debt;
    }
}
