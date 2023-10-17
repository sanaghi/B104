package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToMany
    private List<EmailAddress> emailAddresses;

    private  String passwordHash;
    private  Long  personId;
    private  Long shippingAddressId;
    private  Long billingAddressId;


    public Customer() {
    }
}
