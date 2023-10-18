package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

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
    private Double debt;
    private String name;

    public Customer() {
    }
}
