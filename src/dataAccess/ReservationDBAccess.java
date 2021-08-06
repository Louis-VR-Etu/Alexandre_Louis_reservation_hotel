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
                reservation = new Reservation(null,
                        data.getInt(""),
                        data.getString(""),
                        null,
                        data.getBoolean(""),
                        data.getInt(""),
                        data.getString(""),
                        data.getString("")); //TODO  correct label
                String couponCode = data.getString("couponCode");
                if(!data.wasNull()){
                    reservation.setCouponCode(couponCode);
                }
                String additionalContact = data.getString("additionalContact");
                if(!data.wasNull()){
                    reservation.setAdditionalContact(additionalContact);
                }
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
        //TODO Verifier avec DB
        try {
            Connection connection = SingletonConnexion.getInstance();
            // todo compare to date
            String sqlInstruction = "delete from reservation where beginingDate = " + reservation.getBeginningDate() + " and roomHotelName= '" + reservation.getHotelName() + "' and roomNumber = '" + reservation.getRoomNumber() + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.executeUpdate();
        }
        catch (Exception exception) {
            throw new DeleteReservationException(exception.getMessage());
        }

    }

    public void updateReservation(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
        //TODO verifier avec DB
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "update members set  beginningDate=?, roomNumber=?, roomHotelName=?, endingDate=?, allInclusive=?, people=?, remarks=?, additionalContact=?, couponCode=?, customerMail=? where nationalNumber = " + reservation.getBeginningDate()+ " and roomHotelName= '" + reservation.getHotelName() + "' and roomNumber = '" + reservation.getRoomNumber() + ";";
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            Date beginDate = new Date(reservationUpdated.getBeginningDate().YEAR, reservationUpdated.getBeginningDate().MONTH, reservationUpdated.getBeginningDate().DAY_OF_MONTH);
            preparedStatement.setDate(1,beginDate);
            preparedStatement.setInt(2, reservationUpdated.getRoomNumber());
            preparedStatement.setString(3, reservationUpdated.getHotelName());
            Date endDate = new Date(reservationUpdated.getBeginningDate().YEAR, reservationUpdated.getBeginningDate().MONTH, reservationUpdated.getBeginningDate().DAY_OF_MONTH);
            preparedStatement.setDate(4, endDate);
            preparedStatement.setBoolean(5, reservationUpdated.getAllInclusive());
            preparedStatement.setInt(6, reservationUpdated.getPeople());
            preparedStatement.setString(8, reservationUpdated.getTitle());
            preparedStatement.setString(9, reservationUpdated.getAdditionalContact());
            preparedStatement.setString(9, reservationUpdated.getCouponCode());
            preparedStatement.setString(10, reservationUpdated.getCustomerMail());


            preparedStatement.executeUpdate();
        }
        catch (Exception exception) {
            throw new UpdateReservationException(exception.getMessage());
        }
    }
}
