package exception;

public class JobTaskReservationPriceException extends Exception{
    private String exception;

    public JobTaskReservationPriceException(String exception){
        this.exception = exception;
    }

    public String getMessage() {
        return "JobTaskReservationPriceException" + exception;
    }
}