package dataAccess;

import exception.AddReservationException;
import exception.DeleteReservationException;
import exception.GetReservationException;
import exception.UpdateReservationException;
import model.Reservation;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


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
            while (data.next()){
                reservation = new Reservation(null,data.getInt(""),data.getString(""),null,data.getBoolean(""),data.getInt(""),data.getString(""),data.getString("")); //TODO  correct labels

                reservations.add(reservation);
            }
            return reservations;
        }
        catch(SQLException exception){
            throw new GetReservationException(exception.getMessage());

        }
    }

    public void addReservation(Reservation reservation) throws AddReservationException {
        //TODO verifier avec DB

//*
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "insert into reservation(beginningDate, roomNumber, roomHotelName, endingDate, allInclusive, people, remarks, additionalContact, couponCode, customerMail) values(str_to_date(?,'%d/%m/%Y'),?,?,str_to_date(?,'%d/%m/%Y'),?,?,?,?,?,?)";
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            GregorianCalendar date = new GregorianCalendar(reservation.getBeginningDate().YEAR, reservation.getBeginningDate().MONTH, reservation.getBeginningDate().DAY_OF_MONTH);
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            String beginDate = df.format(date);
            preparedStatement.setString(1,beginDate);
            preparedStatement.setInt(2, reservation.getRoomNumber());
            preparedStatement.setString(3, reservation.getHotelName());
            GregorianCalendar date2 = new GregorianCalendar(reservation.getBeginningDate().YEAR, reservation.getBeginningDate().MONTH, reservation.getBeginningDate().DAY_OF_MONTH);
            String endDate = df.format(date2);
            preparedStatement.setString(4, endDate);
            preparedStatement.setBoolean(5, reservation.getAllInclusive());

            preparedStatement.setInt(6, reservation.getPeople());
            preparedStatement.setString(8, reservation.getTitle());
            preparedStatement.setString(9, reservation.getAdditionalContact());
            preparedStatement.setString(9, reservation.getCouponCode());
            preparedStatement.setString(10, reservation.getCustomerMail());
            preparedStatement.executeUpdate();
        }

        catch (SQLException exception) {
            throw new AddReservationException(exception.getMessage());
        }
        //*/
    }

    public void deleteReservation(Reservation reservation) throws DeleteReservationException {
        //TODO
    }

    public void updateReservation(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
        //TODO
    }
}
