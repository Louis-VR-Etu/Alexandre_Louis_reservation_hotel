package business;

import dataAccess.ReservationDBAccess;
import exception.*;
import model.Reservation;
import model.Room;

import java.util.ArrayList;
import java.util.Date;

public class ReservationManager {
    private ReservationDBAccess reservationDB;

    public ReservationManager(){reservationDB=new ReservationDBAccess();}
    public ArrayList<Reservation> getReservations() throws GetReservationException {
        try { return reservationDB.getReservations();}
        catch (GetReservationException exception) {throw exception;}

    }

    public void addReservations(Reservation reservation) throws AddReservationException {
        //todo
    }

    public void deleteReservation(Reservation reservation)throws DeleteReservationException {
        //todo
    }

    public void updateReservation(Reservation reservation, Reservation reservationUpdated)throws UpdateReservationException {
        //todo
    }

    public ArrayList<String> stringReservations(ArrayList<Reservation> reservations) {
        //todo
        return null;
    }

    public Date verifyBeginningDate(String day, String month, String year) throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyRoomNumber(String roomNumber) throws AddReservationException{
        //todo
        return null;
    }

    public String verifyHotelName(String hotelName)throws AddReservationException {
        //todo
        return null;
    }

    public Date verifyEndingDate(String day, String month, String year)throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyAllInclusive(String allInclusive) throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyPeople(String people) throws AddReservationException{
        //todo
        return null;
    }

    public String verifyTitle(String title)throws AddReservationException {
        //todo
        return null;
    }

    public String verifyAdditionalContact(String additionalContact)throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyCouponCode(String couponCode)throws AddReservationException {
        //todo
        return null;
    }

    public String verifyCustomerMail(String customerMail)throws AddReservationException {
        //todo
        return null;
    }
}
