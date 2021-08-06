package dataAccess;

import exception.AddReservationException;
import exception.DeleteReservationException;
import exception.GetReservationException;
import exception.UpdateReservationException;
import model.Reservation;

import java.sql.*;
import java.util.ArrayList;


public class ReservationDBAccess {
    public ReservationDBAccess(){}

    public ArrayList<Reservation> getReservations() throws GetReservationException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from Reservation";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Reservation>reservations = new ArrayList<>();
            Reservation reservation;
            int iObject=0;
            while (data.next()){
                reservation = new Reservation(null,data.getInt(""),data.getString(""),null,data.getBoolean(""),data.getInt(""),data.getString(""),data.getString("")); //TODO correct labels

                reservations.add(reservation);
            }
            return reservations;
        }
        catch(SQLException exception){
            throw new GetReservationException(exception.getMessage());

        }
    }

    public void addReservation(Reservation reservation) throws AddReservationException {
        //TODO
    }

    public void deleteReservation(Reservation reservation) throws DeleteReservationException {
        //TODO
    }

    public void updateReservation(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
//TODO
    }
}
