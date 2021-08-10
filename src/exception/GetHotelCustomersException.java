package exception;

public class GetHotelCustomersException extends Exception {
    private String exception;

    public GetHotelCustomersException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "GetHotelCustomersException" + exception;
    }
}
