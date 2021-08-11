package dataAccess;

import exception.AddReservationException;
import exception.DeleteReservationException;
import exception.GetReservationException;
import exception.UpdateReservationException;
import model.Reservation;
import model.ReservationPrice;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class ReservationDBAccess {
    public ReservationDBAccess(){}

    public ArrayList<Reservation> getReservations() throws GetReservationException {
        //TODO erreur ici
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from reservation";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Reservation>reservations = new ArrayList<>();
            Reservation reservation;
            while (data.next()) {

                reservation = new Reservation(dateToGregorian(data.getDate("beginningDate")), //TODO test
                        data.getInt("roomNumber"),
                        data.getString("roomHotelName"),
                        dateToGregorian(data.getDate("endingDate")),
                        data.getBoolean("allInclusive"),
                        data.getInt("people"),
                        data.getString("remarks"),
                        data.getString("customerMail"));
                String couponCode = data.getString("couponCode");
                if (!data.wasNull()) {
                    reservation.setCouponCode(couponCode);
                }
                String additionalContact = data.getString("additionalContact");
                if (!data.wasNull()) {
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
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            preparedStatement.setString(1,df.format(reservation.getBeginningDate().getTime()));
            preparedStatement.setInt(2, reservation.getRoomNumber());
            preparedStatement.setString(3, reservation.getHotelName());
            preparedStatement.setString(4, df.format(reservation.getEndingDate().getTime()));
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
        try {
            Connection connection = SingletonConnexion.getInstance();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String sqlInstruction = "delete from reservation where beginningDate = str_to_date(?,'%d/%m/%Y') and roomHotelName= ? and roomNumber = ? ;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setString(1,df.format(reservation.getBeginningDate().getTime()));

            preparedStatement.setString(2,reservation.getHotelName());

            preparedStatement.setString(3,""+reservation.getRoomNumber());

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
            String sqlInstruction = "update reservation set  beginningDate=?, roomNumber=?, roomHotelName=?, endingDate=?, allInclusive=?, people=?, remarks=?, additionalContact=?, couponCode=?, customerMail=? where beginningDate = " + reservation.getBeginningDate()+ " and roomHotelName= '" + reservation.getHotelName() + "' and roomNumber = '" + reservation.getRoomNumber() + ";";
            connection.setAutoCommit(true);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            String pattern = "dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            preparedStatement.setString(1,df.format(reservationUpdated.getBeginningDate().getTime()));
            preparedStatement.setInt(2, reservationUpdated.getRoomNumber());
            preparedStatement.setString(3, reservationUpdated.getHotelName());
            preparedStatement.setString(4, df.format(reservationUpdated.getBeginningDate().getTime()));
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
    public GregorianCalendar dateToGregorian(Date date){ //todo correct class?
        GregorianCalendar correctDate= new GregorianCalendar();
        correctDate.setTime(date);
        return correctDate;
    }
}
