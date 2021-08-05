package exception;

public class HotelAccessException extends Exception {
    private String exception;
    public HotelAccessException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "HotelAccessException " + exception;
    }
}
