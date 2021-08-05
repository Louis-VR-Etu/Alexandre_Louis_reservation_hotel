package business;

import dataAccess.ReservationDBAccess;
import exception.ReservationAccessException;
import exception.RoomAccessException;
import model.Reservation;
import model.Room;

import java.util.ArrayList;

public class ReservationManager {
    private ReservationDBAccess reservationDB;

    public ReservationManager(){reservationDB=new ReservationDBAccess();}
    public ArrayList<Reservation> getReservations() throws ReservationAccessException {
        try { return reservationDB.getReservations();}
        catch (ReservationAccessException exception) {throw exception;}

    }
}
