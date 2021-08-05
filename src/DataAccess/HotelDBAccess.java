package DataAccess;

import model.Hotel;
import java.sql.*;
import java.util.ArrayList;


public class HotelDBAccess {
    public HotelDBAccess(){}

    public ArrayList<Hotel> getHotels() throws Exception{
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from hotel";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Hotel>hotels = new ArrayList<>();
            Hotel hotel;
            int iObject=0;
            while (data.next()){
                hotel = new Hotel(data.getString(""),data.getString(""),data.getBoolean(""),data.getFloat("")); //TODO correct labels

                hotels.add(hotel);
            }
            return hotels;
        }
        catch(SQLException exception){
            throw new Exception();

        }
    }
}
