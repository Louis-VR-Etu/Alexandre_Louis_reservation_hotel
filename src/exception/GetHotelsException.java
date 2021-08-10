package exception;

public class GetHotelsException extends Exception {
    private String exception;
    public GetHotelsException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "HotelAccessException " + exception;
    }
}
