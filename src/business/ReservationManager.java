package business;

import dataAccess.ReservationDBAccess;

public class ReservationManager {
    private ReservationDBAccess reservationDB;

    public ReservationManager(){reservationDB=new ReservationDBAccess();}

}
