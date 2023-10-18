package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;
    private  String description;
    private  Double price;

    @ManyToOne
    Category category;
}
