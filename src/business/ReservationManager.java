package business;

import dataAccess.ReservationDBAccess;
import exception.*;
import model.Reservation;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ReservationManager {
    private ReservationDBAccess reservationDB;

    public ReservationManager() {
        reservationDB = new ReservationDBAccess();
    }

    public ArrayList<Reservation> getReservations() throws GetReservationException {
        try {
            return reservationDB.getReservations();
        } catch (GetReservationException exception) {
            throw exception;
        }
    }

    public void addReservation(Reservation reservation) throws AddReservationException {
        try {
            reservationDB.addReservation(reservation);
        } catch (AddReservationException exception) {
            throw exception;
        }
    }

    public void deleteReservation(Reservation reservation) throws DeleteReservationException {
        try {
            reservationDB.deleteReservation(reservation);
        } catch (DeleteReservationException exception) {
            throw exception;
        }
    }

    public void updateReservation(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
        try {
            if(freeToUpdate(reservation,reservationUpdated)) {
                reservationDB.updateReservation(reservation, reservationUpdated);
            }
            else{
                JOptionPane.showMessageDialog(null, "this room is already occupied on these dates", "Occupied", JOptionPane.ERROR_MESSAGE);

            }
        }
        catch (UpdateReservationException exception) {
            throw exception;
        }
    }

    public boolean freeToUpdate(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
        try {
            ArrayList<Reservation> conflicting = reservationDB.conflictingReservations(reservationUpdated);
            if(conflicting.size()==0){ return true;}
            if(conflicting.size()==1){
                if(reservation.getBeginningDate().compareTo(conflicting.get(0).getBeginningDate())==0) return true;
            }
            return false;
        } catch (UpdateReservationException exception) {
                throw exception;
        }
    }

    public ArrayList<String> stringReservations(ArrayList<Reservation> reservations) {
        ArrayList<String> reservationString = new ArrayList<>();
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        for (int iReserv = 0; iReserv < reservations.size(); iReserv++) {
            reservationString.add(reservations.get(iReserv).getCustomerMail() + ", Hotel " +
                    reservations.get(iReserv).getHotelName() + " chambre " + reservations.get(iReserv).getRoomNumber() +
                    " du " + df.format(reservations.get(iReserv).getBeginningDate().getTime()) + " au " + df.format(reservations.get(iReserv).getEndingDate().getTime())); //TODO format date
        }
        return reservationString;
    }

    public Reservation researchReservation(String reservationString, ArrayList<Reservation> reservations) {
        boolean isFound = false;
        int iReserv = 0;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while (iReserv < reservations.size() && !isFound) {
            isFound = reservationString.compareTo(reservations.get(iReserv).getCustomerMail() + ", Hotel " +
                    reservations.get(iReserv).getHotelName() + " chambre " + reservations.get(iReserv).getRoomNumber() +
                    " du " + df.format(reservations.get(iReserv).getBeginningDate().getTime()) + " au " + df.format(reservations.get(iReserv).getEndingDate().getTime())) == 0;
            iReserv++;
        }
        return reservations.get(iReserv-1);
    }

    public GregorianCalendar verifyBeginningDate(String day, String month, String year) throws AddReservationException {
        try {
            return new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (NumberFormatException exception) {
            throw new AddReservationException("wrong beginning date");
        }
    }

    public Integer verifyRoomNumber(String roomNumber) throws AddReservationException {
        try {
            return verifyNumber(roomNumber);
        } catch (Exception exception) {
            throw new AddReservationException("Wrong room number");
        }
    }

    public String verifyHotelName(String hotelName) throws AddReservationException {
        try {
            return verifyString(hotelName);
        } catch (Exception exception) {
            throw new AddReservationException("wrong hotel name");
        }
    }

    public GregorianCalendar verifyEndingDate(String day, String month, String year) throws AddReservationException {
        try {
            return new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (NumberFormatException exception) {
            throw new AddReservationException("wrong ending date");
        }
    }

    public Integer verifyAllInclusive(String allInclusive) throws AddReservationException {
        try {
            return verifyNumber(allInclusive);
        } catch (Exception exception) {
            throw new AddReservationException("Wrong all in");
        }
    }

    public Integer verifyPeople(String people) throws AddReservationException {
        try {
            return verifyNumber(people);
        } catch (Exception exception) {
            throw new AddReservationException("Wrong amount of people");
        }
    }

    public String verifyTitle(String title) throws AddReservationException {
        try {
            return verifyString(title);
        } catch (Exception exception) {
            throw new AddReservationException("wrong title");
        }
    }

    public String verifyAdditionalContact(String additionalContact) throws AddReservationException {
        try {
            return verifyString(additionalContact);
        } catch (Exception exception) {
            throw new AddReservationException("wrong additional conctacts");
        }
    }

    public String verifyCouponCode(String couponCode) throws AddReservationException {
        try {
            return verifyString(couponCode);
        } catch (Exception exception) {
            throw new AddReservationException("Wrong couponCode");
        }
    }

    public Integer verifyNumber(String number) throws Exception {
        if (number.compareTo("") == 0) {
            throw new Exception("number");
        } else {
            boolean isGood = true;
            int iNumber = 0;
            while (iNumber < number.length() && isGood) {
                isGood = number.charAt(iNumber) == '0' || number.charAt(iNumber) == '1' || number.charAt(iNumber) == '2' || number.charAt(iNumber) == '3' || number.charAt(iNumber) == '4' || number.charAt(iNumber) == '5' || number.charAt(iNumber) == '6' || number.charAt(iNumber) == '7' || number.charAt(iNumber) == '8' || number.charAt(iNumber) == '9';
                iNumber++;
            }
            if (isGood) {
                return Integer.parseInt(number);
            } else {
                throw new Exception("number");
            }
        }
    }

    public String verifyString(String text) throws Exception {
        if (text.compareTo("") == 0) {
            throw new Exception("string");
        } else {
            return text;
        }
    }
}