package exception;

public class GetReservationException extends Exception{
    private String exception;

    public GetReservationException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "GetMemberException" + exception;
    }
}
