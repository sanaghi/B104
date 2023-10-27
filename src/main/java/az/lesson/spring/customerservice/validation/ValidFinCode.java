package az.lesson.spring.customerservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]{7}$", message = "Invalid finCode. It must be a 7-character string with at least one digit and one letter.")
@Documented
public @interface ValidFinCode {
    String message() default "Invalid finCode. It must be a 7-character string with at least one digit and one letter.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}