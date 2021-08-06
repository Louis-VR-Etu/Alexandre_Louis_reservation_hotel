package business;

import dataAccess.HotelDBAccess;
import exception.HotelAccessException;
import model.Hotel;

import java.util.ArrayList;

public class HotelManager {
    private HotelDBAccess hotelDB;
    public HotelManager(){hotelDB = new HotelDBAccess();}

    public ArrayList<Hotel> getHotels() throws HotelAccessException {
        try { return hotelDB.getHotels();}
        catch (HotelAccessException exception) {throw exception;}

    }

    public ArrayList<String> stringHotelNames(ArrayList<Hotel> hotels) {
        ArrayList<String> hotelNames = new ArrayList<>();

        for (int iHotel = 0 ; iHotel < hotels.size() ; iHotel++) {
            hotelNames.add(hotels.get(iHotel).getName());
        }
        return hotelNames;
    }
}

