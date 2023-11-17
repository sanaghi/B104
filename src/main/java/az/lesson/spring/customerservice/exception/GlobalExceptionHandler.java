package az.lesson.spring.customerservice.exception;

import az.lesson.spring.customerservice.enums.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception e){
//        return new ResponseEntity<>("Daxili səhv ",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerException(Exception e){
        return new ResponseEntity<>(ErrorMessages.CUSTOMER_NOT_FOUND.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidParamExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = "";
            if (error instanceof FieldError) {
                fieldName = ((FieldError) error).getField();
            }
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
    }
}