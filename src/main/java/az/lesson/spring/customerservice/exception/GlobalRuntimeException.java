package az.lesson.spring.customerservice.exception;

public class GlobalRuntimeException extends  RuntimeException{
    private final String message;

    public GlobalRuntimeException(String message) {
        super();
        this.message = message;
    }
    public String getMessage(){
        return  message;
    }
}
