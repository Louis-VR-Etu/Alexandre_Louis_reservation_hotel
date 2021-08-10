package dataAccess;

import exception.ResearchFreeRoomsException;
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

    public ArrayList<RoomAndBed> getFreeRooms(String hotelName, Date beginningDate, Date endingDate, int people) throws ResearchFreeRoomsException {
        ArrayList<RoomAndBed> freeRooms = new ArrayList<>();
        try{
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select ro.*, rt.singleBed, rt.doubleBed "+
                    "from room ro, reservation r, roomType rt, room oro " +
                    "    where      ro.roomTypeName = rt.typeName" +
                    "    and      r.roomHotelName = oro.hotelName and r.roomNumber = oro.number" +
                    "    and     (ro.hotelName != r.roomHotelName or ro.number != r.roomNumber)" +
                    "    and not (r.beginningDate < str_to_date(?,'%d/%m/%Y') and r.endingDate > str_to_date(?,'%d/%m/%Y'))" +
                    "    and not (r.endingDate > str_to_date(?,'%d/%m/%Y') and r.endingDate < str_to_date(?,'%d/%m/%Y'))" +
                    "    and not (r.beginningDate > str_to_date(?,'%d/%m/%Y') and r.beginningDate < str_to_date(?,'%d/%m/%Y'))" +
                    "    and rt.singleBed + 2* rt.doubleBed > ?" +
                    "    and ro.hotelName =?" +
                    "    ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            String format ="dd/MM/yyyy";
            DateFormat df = new SimpleDateFormat(format);
            String beginDateStr = df.format(beginningDate);
            String endDateStr = df.format(endingDate);
            preparedStatement.setString(1,beginDateStr);
            preparedStatement.setString(3,beginDateStr);
            preparedStatement.setString(5,beginDateStr);
            preparedStatement.setString(2,endDateStr);
            preparedStatement.setString(4,endDateStr);
            preparedStatement.setString(6,endDateStr);
            preparedStatement.setString(7," "+ people);
            preparedStatement.setString(8,hotelName);
            ResultSet data = preparedStatement.executeQuery();
            RoomAndBed freeRoom;

            while(data.next()){
                freeRoom = new RoomAndBed(data.getInt("number"),data.getInt("floor"),data.getString("hotelName"), data.getString("roomTypeName"),data.getInt("singleBed") ,data.getInt("doubleBed"));
                //new RoomAndBed(1,1,1,1,1,1);
                freeRooms.add(freeRoom);
            }
        } catch (Exception exception) {
            throw new ResearchFreeRoomsException(exception.getMessage());
        }
        return freeRooms;

    }
}
