package business;

import dataAccess.HotelDBAccess;
import exception.HotelAccessException;
import model.Hotel;

import java.util.ArrayList;

public class HotelManager {
    private HotelDBAccess hotelDB;
    public HotelManager(){hotelDB = new HotelDBAccess();}

    public ArrayList<Hotel> getCustomers() throws HotelAccessException {
        try { return hotelDB.getHotels();}
        catch (HotelAccessException exception) {throw exception;}

    }

}

