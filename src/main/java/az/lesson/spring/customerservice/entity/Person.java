package az.lesson.spring.customerservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer  id;

    String name;
    String surName;
    String ptrcName;

    @Temporal(TemporalType.DATE)
    Date birhDate;

    String gender;
    Integer height;

    @Column(name = "finCode" , nullable = false,unique = true)
    String finCode;


//    @OneToOne(mappedBy = "person")
//    private Customer customer;
}