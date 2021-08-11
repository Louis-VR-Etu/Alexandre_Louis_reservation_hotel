package exception;

public class UpdateReservationException extends Exception{
    private String exception;

    public UpdateReservationException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "UpdateReservationException" + exception;
    }
}
