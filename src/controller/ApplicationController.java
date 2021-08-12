package controller;

import business.*;
import exception.*;
import model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class ApplicationController {
    private CustomerManager customerManager;
    private HotelManager hotelManager;
    private ReservationManager reservationManager;
    private RoomManager roomManager;
    private RoomTypeManager roomTypeManager;
    private JobTaskManager jobTaskManager;

    public ApplicationController(){
        customerManager = new CustomerManager();
        hotelManager = new HotelManager();
        reservationManager = new ReservationManager();
        roomManager = new RoomManager();
        roomTypeManager= new RoomTypeManager();
        jobTaskManager = new JobTaskManager();
    }

    public void addReservation(Reservation reservation) throws AddReservationException {
        try {
            reservationManager.addReservation(reservation);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public void deleteReservation(Reservation reservation) throws DeleteReservationException {
        try {
            reservationManager.deleteReservation(reservation);
        }
        catch (DeleteReservationException exception) {
            throw exception;
        }
    }

    public void updateReservation(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
        try {
            reservationManager.updateReservation(reservation, reservationUpdated);
        }
        catch (UpdateReservationException exception) {
            throw exception;
        }
    }

    public ArrayList<Reservation> getReservations() throws GetReservationException {
        try{
            return reservationManager.getReservations();
        }
        catch (GetReservationException exception) {
            throw exception;
        }
    }

    public ArrayList<Customer> getCustomers() throws CustomerAccessException {
        try {
            return customerManager.getCustomers();
        }
        catch (CustomerAccessException exception) {
            throw exception;
        }
    }

    public ArrayList<Hotel> getHotels() throws GetHotelsException {
        try {
            return hotelManager.getHotels();
        }
        catch (GetHotelsException exception) {
            throw exception;
        }
    }

    public ArrayList<RoomType> getRoomTypes() throws RoomTypeAccessException {
        try {
            return roomTypeManager.getRoomTypes();
        }
        catch (RoomTypeAccessException exception) {
            throw exception;
        }
    }

    public ArrayList<String> stringCustomerMail(ArrayList<Customer> customers) { return customerManager.stringCustomerMail(customers); }

    public ArrayList<String> stringReservation(ArrayList<Reservation> reservations) { return reservationManager.stringReservations(reservations);}

    public ArrayList<String> stringHotelNames(ArrayList<Hotel> hotels) { return hotelManager.stringHotelNames(hotels);}

    public ArrayList<String> stringRoomTypeNames(ArrayList<RoomType> roomTypeNames) { return roomTypeManager.stringRoomTypeNames(roomTypeNames); }

    public ArrayList<String> stringFreeRoomType(ArrayList<RoomAndBed> freeRooms) { return roomManager.stringFreeRoomType(freeRooms);    }

    public Reservation researchReservation(String reservationString, ArrayList<Reservation> reservations) { return reservationManager.researchReservation(reservationString, reservations); }

    public Room researchRoom(String roomString, ArrayList<Room> rooms){ return roomManager.researchRoom(roomString, rooms); }

    public RoomAndBed researchFreeRoom(String roomString, ArrayList<RoomAndBed> rooms){ return roomManager.researchFreeRoom(roomString, rooms); }

    public Hotel researchHotel(String hotelString, ArrayList<Hotel> hotels){ return hotelManager.researchHotel(hotelString, hotels); }

    public Customer researchCustomer(String customerString, ArrayList<Customer> customers){ return customerManager.researchCustomer(customerString, customers); }

    public GregorianCalendar verifyBeginningDate(String day, String month, String year) throws AddReservationException {
        try {
            return reservationManager.verifyBeginningDate(day, month, year);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public Integer verifyRoomNumber(String roomNumber) throws AddReservationException {
        try {
            return reservationManager.verifyRoomNumber(roomNumber);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public String verifyHotelName(String hotelName) throws AddReservationException {
        try {
            return reservationManager.verifyHotelName(hotelName);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public GregorianCalendar verifyEndingDate(String day, String month, String year) throws AddReservationException {
        try {
            return reservationManager.verifyEndingDate(day, month, year);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public Integer verifyGSMNumber(String allInclusive) throws AddReservationException {
        try {
            return reservationManager.verifyAllInclusive(allInclusive);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public Integer verifyPeople(String people) throws AddReservationException {
        try {
            return reservationManager.verifyPeople(people);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public String verifyTitle(String title) throws AddReservationException {
        try {
            return reservationManager.verifyTitle(title);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

      public String verifyAdditionalContact(String additionalContact) throws AddReservationException {
        try {
            return reservationManager.verifyAdditionalContact(additionalContact);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public String verifyCouponCode(String couponCode) throws AddReservationException {
        try {
            return reservationManager.verifyCouponCode(couponCode);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public ArrayList<RoomAndBed> getFreeRooms(String hotelName, Date beginningDate , Date endingDate, int people) throws GetFreeRoomsException {
        try{
            return roomManager.getFreeRooms(hotelName,beginningDate,endingDate,people);
        } catch(GetFreeRoomsException exception){
            throw exception;
        }
    }

    public ArrayList<CustomerRoom> getCustomersRoom(String hotelSelected) throws GetHotelCustomersException {
        try{
            return customerManager.getCustomersRoom(hotelSelected);
        } catch(GetHotelCustomersException exception){
            throw exception;
        }
    }

    public ArrayList<HotelPrice> getCustomerHotels(String customerSelected, int priceMin) throws GetCustomerHotelsException {
        try{
            return hotelManager.getCustomerHotels(customerSelected, priceMin);
        } catch(GetCustomerHotelsException exception){
            throw exception;
        }
    }

    public String jobTaskReservationPrice(Reservation reservation) throws JobTaskReservationPriceException {
        try{
            return jobTaskManager.jobTaskReservationPrice(reservation);
        }
        catch(JobTaskReservationPriceException exception){
            throw exception;
        }
    }

    public ReservationManager getReservationManager() {
        return this.reservationManager;
    }

    public Boolean verifyDates(Date beginningDate, Date endingDate){
        return beginningDate.compareTo(endingDate) < 0;
    }
}
