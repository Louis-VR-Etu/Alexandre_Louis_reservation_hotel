package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CustomerHotelsModel extends AbstractTableModel {
    private ArrayList<HotelPrice> contents;
    private ArrayList<String> columnNames;

    public void setContents(ArrayList<HotelPrice> contents){
        this.contents = contents;
    }

    public CustomerHotelsModel(ArrayList<HotelPrice> hotels){
        columnNames = new ArrayList<>();
        columnNames.add("hotel name");
        columnNames.add("address");
        columnNames.add("roomType");
        columnNames.add("price per night");
        setContents(hotels);
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
        HotelPrice hotelPrice = contents.get(row);
        return switch (column) {
            case 0 -> hotelPrice.getHotelName();
            case 1 -> hotelPrice.getAddress();
            case 2 -> hotelPrice.getRoomType();
            case 3 -> hotelPrice.getPrice();
            default -> null;
        };
    }
}
