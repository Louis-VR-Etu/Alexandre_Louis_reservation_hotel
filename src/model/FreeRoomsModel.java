package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class FreeRoomsModel extends AbstractTableModel {
    private ArrayList<RoomAndBed> contents;
    private ArrayList<String> columnNames;

    public void setContents(ArrayList<RoomAndBed> contents){
        this.contents = contents;
    }

    public FreeRoomsModel(ArrayList<RoomAndBed> rooms){
        columnNames = new ArrayList<>();
        columnNames.add("hotel name");
        columnNames.add("room number");
        columnNames.add("floor");
        columnNames.add("roomType");
        columnNames.add("single beds");
        columnNames.add("double beds");
        setContents(rooms);
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
        RoomAndBed freeRoom = contents.get(row);
        return switch (column) {
            case 0 -> freeRoom.getHotelName();
            case 1 -> freeRoom.getNumber();
            case 2 -> freeRoom.getFloor();
            case 3 -> freeRoom.getRoomType();
            case 4 -> freeRoom.getSingleBed();
            case 5 -> freeRoom.getDoubleBed();
            default -> null;
        };
    }
}
