package dataAccess;

import exception.RoomAccessException;
import exception.RoomTypeAccessException;
import model.Room;
import model.RoomType;
import java.sql.*;
import java.util.ArrayList;


public class RoomTypeDBAccess {
    public RoomTypeDBAccess(){}

    public ArrayList<RoomType> getRoomTypes() throws RoomTypeAccessException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String sqlInstruction = "select * from roomType";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();
            ArrayList<RoomType>roomTypes = new ArrayList<>();
            RoomType roomType;
            while (data.next()){
                roomType = new RoomType(data.getString("typename"),data.getFloat("price/night"),data.getInt("singlebed"),data.getInt("doublebed"));
                roomTypes.add(roomType);
            }
            return roomTypes;
        }
        catch(SQLException exception){
            throw new RoomTypeAccessException(exception.getMessage());

        }
    }
}
