package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class HotelCustomersModel extends AbstractTableModel {
    private ArrayList<CustomerRoom> contents;
    private ArrayList<String> columnNames;

    public HotelCustomersModel(ArrayList<CustomerRoom> contents) {
        columnNames = new ArrayList<>();
        columnNames.add("mail");
        columnNames.add("name");
        columnNames.add("surname");
        columnNames.add("roomType");
        setContents(contents);
    }

    private void setContents(ArrayList<CustomerRoom> contents) {
        this.contents = contents;
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
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int row, int column) {
        CustomerRoom customerRoom = contents.get(row);
        switch (column) {
            case 0:
                return customerRoom.getMail();
            case 1:
                return customerRoom.getName();
            case 2:
                return customerRoom.getSurname();
            case 3:
                return customerRoom.getRoomType();
            default:
                return null;
        }
    }
}
