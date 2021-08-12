package dataAccess;

import exception.GetFreeRoomsException;
import exception.RoomAccessException;
import model.Room;
import model.RoomAndBed;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
            while (data.next()){
                room = new Room(data.getInt("number"),data.getInt("floor"),data.getString("hotelName"),data.getString("roomTypeName"));
                rooms.add(room);
            }
            return rooms;
        }
        catch(SQLException exception){
            throw new RoomAccessException(exception.getMessage());
        }
    }

    public ArrayList<RoomAndBed> getFreeRooms(String hotelName, Date beginningDate, Date endingDate, int people) throws GetFreeRoomsException {
        ArrayList<RoomAndBed> freeRooms = new ArrayList<>();
        try{
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select  ro.*, rt.singleBed, rt.doubleBed from room ro,  roomType rt "+
                    "where   ro.roomTypeName = rt.typeName "+
                    "and (rt.singleBed + 2 * rt.doubleBed >= ?) "+
                    "and ro.hotelName = ? "+
                    "and (ro.number, ro.hotelname) not in ( select r.roomNumber, r.roomHotelName from reservation r, room oro, roomType rt "+
                    "where  (r.beginningDate <= str_to_date(?,'%d/%m/%Y') and r.endingDate > str_to_date(?,'%d/%m/%Y'))  "+ //bb
                    "or  (r.endingDate >= str_to_date(?,'%d/%m/%Y') and r.beginningDate < str_to_date(?,'%d/%m/%Y')) " + //ee
                    "or  (r.beginningDate >= str_to_date(?,'%d/%m/%Y') and r.endingDate <= str_to_date(?,'%d/%m/%Y')) ) "+ //be
                    ";";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            String format ="dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(format);
            String beginDateStr = df.format(beginningDate);
            String endDateStr = df.format(endingDate);
            preparedStatement.setString(3,beginDateStr);
            preparedStatement.setString(4,beginDateStr);
            preparedStatement.setString(7,beginDateStr);
            preparedStatement.setString(5,endDateStr);
            preparedStatement.setString(6,endDateStr);
            preparedStatement.setString(8,endDateStr);
            preparedStatement.setString(1," "+ people);
            preparedStatement.setString(2,hotelName);
            ResultSet data = preparedStatement.executeQuery();
            RoomAndBed freeRoom;
            while(data.next()){
                freeRoom = new RoomAndBed(data.getInt("number"),data.getInt("floor"),data.getString("hotelName"), data.getString("roomTypeName"),data.getInt("singleBed") ,data.getInt("doubleBed"));
                freeRooms.add(freeRoom);
            }
        } catch (Exception exception) {
            throw new GetFreeRoomsException(exception.getMessage());
        }
        return freeRooms;
    }
}
