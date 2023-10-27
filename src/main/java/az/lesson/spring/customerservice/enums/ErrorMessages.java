package az.lesson.spring.customerservice.enums;


public enum ErrorMessages {
    CUSTOMER_NOT_FOUND("Müştəri tapılmadı"),
    WRONG_FIN_CODE_FORMAT("FIN code doğru deyil "),
    INVALID_EMAIL_ADDRESS("Email doğru deyil");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
    public String getMessage(){
        return  message;
    }
}
