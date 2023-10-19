package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private  Long productId;
    private  Double itemPrice;
    private  Double discountAmmont;

    @ManyToOne
    Orders order;
}
