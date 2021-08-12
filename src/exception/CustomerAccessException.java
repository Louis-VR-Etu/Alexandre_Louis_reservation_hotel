package exception;

public class CustomerAccessException extends Exception {
    private String exception;

    public CustomerAccessException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "CustomerAccessException " + exception;
    }
}
