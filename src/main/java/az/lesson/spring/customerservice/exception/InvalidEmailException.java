package az.lesson.spring.customerservice.exception;

public class InvalidEmailException extends GlobalRuntimeException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
