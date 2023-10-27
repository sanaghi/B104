package az.lesson.spring.customerservice.exception;

public class CustomerNotFoundException extends GlobalRuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

