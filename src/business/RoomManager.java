package business;

import dataAccess.RoomDBAccess;
import exception.GetFreeRoomsException;
import exception.RoomAccessException;
import model.Room;
import model.RoomAndBed;

import java.util.ArrayList;
import java.util.Date;

public class RoomManager {
    private RoomDBAccess roomDB;
    public RoomManager(){roomDB = new RoomDBAccess();}

    public ArrayList<Room> getRooms() throws RoomAccessException {
        try { return roomDB.getRooms();}
        catch (RoomAccessException exception) {throw exception;}

    }
    public Room researchRoom(String roomString, ArrayList<Room> rooms) {
        boolean isFound = false;
        int iRoom = 0;
        while (iRoom < rooms.size() && !isFound) {
            isFound = roomString.compareTo(rooms.get(iRoom).getNumber() + ", " + rooms.get(iRoom).getHotelName()) == 0;
            iRoom++;
        }
        return rooms.get(iRoom-1);
    }

    public ArrayList<RoomAndBed> getFreeRooms(String hotelName, Date beginningDate, Date endingDate, int people) throws GetFreeRoomsException {
        try{
            return roomDB.getFreeRooms(hotelName,beginningDate,endingDate,people);
        }
        catch(GetFreeRoomsException exception){
            throw exception;
        }
    }
}
