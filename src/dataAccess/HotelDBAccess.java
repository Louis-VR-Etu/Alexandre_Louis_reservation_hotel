package dataAccess;

import exception.GetHotelsException;
import model.Hotel;
import java.sql.*;
import java.util.ArrayList;


public class HotelDBAccess {
    public HotelDBAccess(){}

    public ArrayList<Hotel> getHotels() throws GetHotelsException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from hotel";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Hotel>hotels = new ArrayList<>();
            Hotel hotel;
            while (data.next()){
                hotel = new Hotel(data.getString("name"),data.getString("address"),data.getBoolean("animals"),data.getFloat("allInclusivePrice"));

                hotels.add(hotel);
            }
            return hotels;
        }
        catch(SQLException exception){
            throw new GetHotelsException(exception.getMessage());

        }
    }
}
