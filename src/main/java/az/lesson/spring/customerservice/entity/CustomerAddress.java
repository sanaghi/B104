package az.lesson.spring.customerservice.entity;

import az.lesson.spring.customerservice.enums.AddressType;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
@Table(name = "customer_address")

public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)//,cascade = CascadeType.ALL
    @JsonBackReference
    @JoinColumn(name = "address_id")
    @OrderBy("id desc ")
    @Fetch(FetchMode.JOIN)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType type;

}
