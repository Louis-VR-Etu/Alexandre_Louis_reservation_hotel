package exception;

public class ResearchFreeRoomsException extends Exception{
    private String exception;

    public ResearchFreeRoomsException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "ResearchFreeRoomsException" + exception;
    }
}
