package dataAccess;

import exception.RoomAccessException;
import model.Room;

import java.sql.*;
import java.util.ArrayList;


public class RoomDBAccess {
    public RoomDBAccess(){}

    public ArrayList<Room> getRooms() throws RoomAccessException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from room";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<Room>rooms = new ArrayList<>();
            Room room;
            int iObject=0;
            while (data.next()){
                room = new Room(data.getInt("number"),data.getInt("floor"),data.getString("hotelname"),data.getString("roomType")); //TODO correct labels
                rooms.add(room);
            }
            return rooms;
        }
        catch(SQLException exception){
            throw new RoomAccessException(exception.getMessage());

        }
    }
}
