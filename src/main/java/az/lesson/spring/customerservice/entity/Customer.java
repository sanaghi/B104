package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    private String emailAddress;

    private  String passwordHash;

    @OneToOne
    @JoinColumn(name = "personFinCode",referencedColumnName = "finCode")
    private  Person  person;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    @Where(clause = "address_tye = 'BILLING' ")
    private List<CustomerAddress> billingAddresses ;

    @Where(clause = "address_tye = 'SHIPPING' ")
    @OneToMany(mappedBy = "customer")
    @Fetch(FetchMode.JOIN)
    private List<CustomerAddress> shippingAddresses;

    private Double debt;
    private String name;

    public Customer() {
    }
}
