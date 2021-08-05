package exception;

public class RoomAccessException extends Exception {
    private String exception;
    public RoomAccessException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return "RoomAccessException " + exception;
    }
}
