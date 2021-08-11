package exception;

public class GetCustomerHotelsException extends Exception {
    private String exception;

    public GetCustomerHotelsException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "GetCustomerHotelsException" + exception;
    }
}
