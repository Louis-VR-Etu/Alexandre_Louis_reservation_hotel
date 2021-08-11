package dataAccess;

import exception.GetHotelCustomersException;
import exception.JobTaskReservationPriceException;
import model.CustomerRoom;
import model.Reservation;
import model.ReservationPrice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JobTaskDBAccess {
    public JobTaskDBAccess() {}

    public ReservationPrice getPriceData(Reservation reservation) throws JobTaskReservationPriceException {
        ReservationPrice reservationPrice=null;
        try{
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select r.beginningDate, r.endingDate,r.people, r.allinclusive, rt.`price/night` as price, h.allinclusivePrice from reservation r, roomtype rt, hotel h, room ro "+
                    "where ro.number=r.roomNumber and ro.hotelName = r.roomHotelName and rt.typeName=ro.roomTypeName and r.roomHotelName = h.name "+
                    "and r.beginningDate = ? and r.roomHotelName = ? and r.roomNumber =? "+
                    ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);
            preparedStatement.setString(1,df.format(reservation.getBeginningDate().getTime()));
            preparedStatement.setString(2,reservation.getHotelName());
            preparedStatement.setString(3,""+reservation.getRoomNumber());
            ResultSet data = preparedStatement.executeQuery();

            while(data.next()) {
                reservationPrice = new ReservationPrice(new GregorianCalendar(), new GregorianCalendar(), data.getDate("beginningDate"), data.getDate("endingDate"), data.getInt("people"), data.getBoolean("allInclusive"), data.getInt("price"), data.getInt("allInclusivePrice"));
            }



        }
        catch(SQLException exception){
            throw new JobTaskReservationPriceException(exception.getMessage());
        }
        return reservationPrice;
    }
}
