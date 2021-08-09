package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class freeRoomModel extends AbstractTableModel {
    private ArrayList<Room> contents;
    private ArrayList<String> columnNames;

    public void setContents(ArrayList<Room> contents){
        this.contents = contents;
    }

    public freeRoomModel(ArrayList<Room> Rooms){
        columnNames = new ArrayList<>();
        columnNames.add("hotel name");
        columnNames.add("room number");
        columnNames.add("floor");
        columnNames.add("roomType");
        //TODO roomtypes beds?
        setContents(Rooms);
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column){
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Room freeRoom = contents.get(row);
        switch (column) {
            case 0 : return freeRoom.getHotelName();
            case 1 : return freeRoom.getNumber();
            case 2 : return freeRoom.getFloor();
            case 3 : return freeRoom.getRoomType();
            default : return null;
        }
    }

}
