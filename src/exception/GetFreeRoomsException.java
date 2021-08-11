package exception;

public class GetFreeRoomsException extends Exception{
    private String exception;

    public GetFreeRoomsException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "GetFreeRoomsException" + exception;
    }
}
