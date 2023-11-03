package az.lesson.spring.customerservice.dto;

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
    private String emailAddress;
    private  Integer age;
    private Double debt;
}
