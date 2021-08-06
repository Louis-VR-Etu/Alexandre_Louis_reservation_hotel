package business;

import dataAccess.ReservationDBAccess;
import exception.*;
import model.Reservation;
import model.Room;

import java.util.ArrayList;
import java.util.Date;

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
        //todo
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
            reservationDB.updateReservation(reservation, reservationUpdated);
        } catch (UpdateReservationException exception) {
            throw exception;
        }
    }

    public ArrayList<String> stringReservations(ArrayList<Reservation> reservations) {
        //todo
        ArrayList<String> reservationString = new ArrayList<>();
        for (int iReserv = 0; iReserv < reservations.size(); iReserv++) {
            //todo verifier String
            reservationString.add(reservations.get(iReserv).getCustomerMail() + ", Hotel" + reservations.get(iReserv).getHotelName() + "chambre " + reservations.get(iReserv).getRoomNumber() + " du " + reservations.get(iReserv).getBeginningDate() + " au " + reservations.get(iReserv).getEndingDate());
        }

        return reservationString;
    }

    public Date verifyBeginningDate(String day, String month, String year) throws AddReservationException {
        try {
            //todo date
            return new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
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

    public Date verifyEndingDate(String day, String month, String year) throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyAllInclusive(String allInclusive) throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyPeople(String people) throws AddReservationException {
        //todo
        return null;
    }

    public String verifyTitle(String title) throws AddReservationException {
        //todo
        return null;
    }

    public String verifyAdditionalContact(String additionalContact) throws AddReservationException {
        //todo
        return null;
    }

    public Integer verifyCouponCode(String couponCode) throws AddReservationException {
        //todo
        return null;
    }

    public String verifyCustomerMail(String customerMail) throws AddReservationException {
        //todo
        return null;
    }

    //todo verifier conditions
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