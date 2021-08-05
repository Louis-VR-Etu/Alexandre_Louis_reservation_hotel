package exception;

public class DeleteReservationException extends Exception{
    private String exception;

    public DeleteReservationException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "GetMemberException" + exception;
    }
}
