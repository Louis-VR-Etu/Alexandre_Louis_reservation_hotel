package exception;

public class AddReservationException extends Exception{
    private String exception;

    public AddReservationException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "GetMemberException" + exception;
    }
}
