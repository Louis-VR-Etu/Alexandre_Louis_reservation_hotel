package model;

import model.Reservation;

import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
              //  Date date1 = new java.sql.Date(reservation.getBeginningDate().YEAR, reservation.getBeginningDate().MONTH, reservation.getBeginningDate().DAY_OF_MONTH);
                String pattern1 = "yyyy-MM-dd";
                DateFormat df1 = new SimpleDateFormat(pattern1);
                String dateString1 = df1.format(reservation.getBeginningDate());
                return dateString1;
            case 1:
                return reservation.getRoomNumber();
            case 2:
                return reservation.getHotelName();
            case 3:
             //   Date date2 = new java.sql.Date(reservation.getEndingDate().YEAR, reservation.getEndingDate().MONTH, reservation.getEndingDate().DAY_OF_MONTH);
                String pattern2 = "yyyy-MM-dd";
                DateFormat df2 = new SimpleDateFormat(pattern2);
                String dateString2 = df2.format(reservation.getEndingDate());
                return dateString2;
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
            Class c;
            switch (column) {
                case 0 : c = String.class;
                    break;
                case 1 : c = Integer.class;
                    break;
                case 2 : c = String.class;
                    break;
                case 3 : c = String.class;
                    break;
                case 4 : c = Integer.class;
                    break;
                case 5 : c = Integer.class;
                    break;
                case 6 : c = String.class;
                    break;
                case 7 : c = String.class;
                    break;
                case 8 : c = Integer.class;
                    break;
                case 9 : c = String.class;
                    break;
                case 10 : c = String.class;
                    break;
                default : c = String.class;
            }
            return c;
        }
}
