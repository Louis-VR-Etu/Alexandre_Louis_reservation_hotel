package exception;

public class RoomTypeAccessException extends Exception {
    private String exception;
    public RoomTypeAccessException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "RoomTypeAccessException " + exception;
    }
}
