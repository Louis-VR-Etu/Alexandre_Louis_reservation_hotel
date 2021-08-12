package business;

import dataAccess.RoomTypeDBAccess;
import exception.RoomTypeAccessException;
import model.RoomType;
import java.util.ArrayList;

public class RoomTypeManager {
    private RoomTypeDBAccess roomTypeDB;

    public RoomTypeManager(){roomTypeDB = new RoomTypeDBAccess();}

    public ArrayList<RoomType> getRoomTypes() throws RoomTypeAccessException {
        try { return roomTypeDB.getRoomTypes();}
        catch (RoomTypeAccessException exception) {throw exception;}
    }
    public ArrayList<String> stringRoomTypeNames(ArrayList<RoomType> roomTypes) {
        ArrayList<String> roomTypeNames = new ArrayList<>();
        for (RoomType roomType : roomTypes) {
            roomTypeNames.add(roomType.getTypeName());
        }
        return roomTypeNames;
    }
}