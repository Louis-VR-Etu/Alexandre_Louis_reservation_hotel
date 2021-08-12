package model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AllReservationsModel extends AbstractTableModel{
    private ArrayList<Reservation> contents;
    private ArrayList<String> columnNames;

    public void setContents(ArrayList<Reservation> contents){
        this.contents = contents;
    }

    public AllReservationsModel(ArrayList<Reservation> reservations){
        columnNames = new ArrayList<>();
        columnNames.add("beginningDate");
        columnNames.add("number");
        columnNames.add("name");
        columnNames.add("endingDate");
        columnNames.add("allInclusive");
        columnNames.add("people");
        columnNames.add("title");
        columnNames.add("additionalContact");
        columnNames.add("couponCode");
        columnNames.add("mail");
        setContents(reservations);
    }

    public int getColumnCount(){
        return columnNames.size();
    }

    public int getRowCount(){
        return contents.size();
    }

    public String getColumnName(int column){
        return columnNames.get(column);
    }

    public Object getValueAt(int row, int column) {
        Reservation reservation = contents.get(row);
        switch (column) {
            case 0:
                if(reservation.getBeginningDate()!=null){
                String pattern1 = "dd/MM/yyyy";
                DateFormat df1 = new SimpleDateFormat(pattern1);
                    return df1.format(reservation.getBeginningDate().getTime());}
            case 1:
                return reservation.getRoomNumber();
            case 2:
                return reservation.getHotelName();
            case 3:
                if(reservation.getBeginningDate()!=null){
                String pattern2 = "dd/MM/yyyy";
                DateFormat df2 = new SimpleDateFormat(pattern2);
                    return df2.format(reservation.getEndingDate().getTime());}
            case 4:
                return reservation.getAllInclusive();
            case 5:
                return reservation.getPeople();
            case 6:
                return reservation.getTitle();
            case 7:
                return reservation.getAdditionalContact();
            case 8:
                return reservation.getCouponCode();
            case 9:
                return reservation.getCustomerMail();
            case 10:
                return "test";
            default:
                return null;
        }
    }

    public Class getColumnClass(int column) {
        return switch (column) {
            case 0 -> String.class;
            case 1 -> Integer.class;
            case 2 -> String.class;
            case 3 -> String.class;
            case 4 -> Integer.class;
            case 5 -> Integer.class;
            case 6 -> String.class;
            case 7 -> String.class;
            case 8 -> Integer.class;
            case 9 -> String.class;
            case 10 -> String.class;
            default -> String.class;
        };
    }
}
