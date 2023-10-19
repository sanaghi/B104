package az.lesson.spring.customerservice.entity;

import az.lesson.spring.customerservice.AddressType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customer_address")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType type;

}
