package business;

import dataAccess.JobTaskDBAccess;
import exception.JobTaskReservationPriceException;
import model.Reservation;
import model.ReservationPrice;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JobTaskManager {
    private JobTaskDBAccess jobTaskDB;

    public JobTaskManager() {this.jobTaskDB = new JobTaskDBAccess();}

   public String jobTaskReservationPrice(Reservation reservation) throws JobTaskReservationPriceException {
    String reservationPrice;
       ReservationPrice data;
        try{
            data = jobTaskDB.getPriceData(reservation);
            long duration = data.getDuration();
            int people = data.getPeople();
            int allIn=0;
            if(data.isAllInclusive()){
                allIn = 1;
            }
            int pricePerNight = data.getPrice();
            int allInPrice = data.getAllInPrice();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            long price = duration*(pricePerNight+((long) allIn *allInPrice*people));
            reservationPrice = "the reservation by "+ reservation.getCustomerMail()+"\n at the hotel "+reservation.getHotelName()+" from "+
                    df.format(reservation.getBeginningDate().getTime())+ " to "+df.format(reservation.getBeginningDate().getTime())+" cost "+price+"€";
            }
        catch(JobTaskReservationPriceException exception){throw exception;}
        return reservationPrice;
    }
}
