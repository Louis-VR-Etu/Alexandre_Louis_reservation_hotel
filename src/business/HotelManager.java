package business;

import dataAccess.HotelDBAccess;
import exception.GetCustomerHotelsException;
import exception.GetHotelsException;
import model.Hotel;
import model.HotelPrice;
import java.util.ArrayList;

public class HotelManager {
    private HotelDBAccess hotelDB;

    public HotelManager(){hotelDB = new HotelDBAccess();}

    public ArrayList<Hotel> getHotels() throws GetHotelsException {
        try { return hotelDB.getHotels();}
        catch (GetHotelsException exception) {throw exception;}
    }

    public ArrayList<String> stringHotelNames(ArrayList<Hotel> hotels) {
        ArrayList<String> hotelNames = new ArrayList<>();
        for (int iHotel = 0 ; iHotel < hotels.size() ; iHotel++) {
            hotelNames.add(hotels.get(iHotel).getName());
        }
        return hotelNames;
    }

    public Hotel researchHotel(String hotelString, ArrayList<Hotel> hotels) {
        boolean isFound = false;
        int iHotel = 0;
        while (iHotel < hotels.size() && !isFound) {
            isFound = hotelString.compareTo(hotels.get(iHotel).getName()) == 0;
            iHotel++;
        }
        return hotels.get(iHotel-1);
    }

    public ArrayList<HotelPrice> getCustomerHotels(String customerSelected, int priceMin) throws GetCustomerHotelsException {
        try{
            return hotelDB.getCustomerHotels(customerSelected, priceMin);
        }
        catch(GetCustomerHotelsException exception){throw exception;}
    }
}

