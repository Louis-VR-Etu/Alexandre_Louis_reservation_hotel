package dataAccess;

import exception.GetCustomerHotelsException;
import exception.GetHotelCustomersException;
import exception.GetHotelsException;
import model.CustomerRoom;
import model.Hotel;
import model.HotelPrice;

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

    public ArrayList<HotelPrice> getCustomerHotels(String customerSelected, int priceMin) throws GetCustomerHotelsException {
        ArrayList<HotelPrice> hotelPrices = new ArrayList<>();
        try{
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select distinct h.name as hotelName, h.address,rt.typeName as roomType, rt.`price/night` as price from hotel h, roomtype rt, room ro, reservation r " +
                    "where  r.customerMail = ? and rt.`price/night` >= ? and r.roomHotelName = h.name and h.name = ro.hotelName and ro.number = r.roomNumber and ro.roomTypeName = rt.typeName;\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setString(1,customerSelected);
            preparedStatement.setString(2," "+priceMin);
            ResultSet data = preparedStatement.executeQuery();

            HotelPrice hotelPrice;

            while(data.next()){
                hotelPrice = new HotelPrice(data.getString("hotelName"),data.getString("address"),data.getString("roomType"),data.getInt("price"));
                hotelPrices.add(hotelPrice);
            }

        }
        catch(SQLException exception){
            throw new GetCustomerHotelsException(exception.getMessage());
        }
        return hotelPrices;
    }
}

