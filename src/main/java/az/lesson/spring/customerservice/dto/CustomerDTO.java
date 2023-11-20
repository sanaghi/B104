package az.lesson.spring.customerservice.dto;

import az.lesson.spring.customerservice.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerDTO {
    private  Long id;
    private String email;
    private  Integer age;
    private Double debt;
    private Person person;
}
