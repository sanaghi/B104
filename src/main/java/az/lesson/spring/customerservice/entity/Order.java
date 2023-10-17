package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long customerId;

    @Temporal(TemporalType.DATE)
    private Date orderDate;


    @Temporal(TemporalType.DATE)
    private Date shipDate;

    private  Double shipAmount;


    private  Double taxAmount;

    private  Long shipAddressId;

    private  Long accountId;
    private  Integer shipAdddressId;
    private  Integer billingAdddressId;







}