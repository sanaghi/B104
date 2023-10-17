package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String email;




}
