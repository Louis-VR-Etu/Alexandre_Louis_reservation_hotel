package business;

import dataAccess.RoomDBAccess;
import exception.RoomAccessException;
import model.Room;

import java.util.ArrayList;

public class RoomManager {
    private RoomDBAccess roomDB;
    public RoomManager(){roomDB = new RoomDBAccess();}

    public ArrayList<Room> getRooms() throws RoomAccessException {
        try { return roomDB.getRooms();}
        catch (RoomAccessException exception) {throw exception;}

    }

}
