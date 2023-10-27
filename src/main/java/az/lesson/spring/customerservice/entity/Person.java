package az.lesson.spring.customerservice.entity;

import az.lesson.spring.customerservice.validation.ValidFinCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    String gender;

    @JsonIgnore
    Integer height;


    @ValidFinCode
    @Column(name = "finCode" , nullable = false,unique = true)
    String finCode;

}