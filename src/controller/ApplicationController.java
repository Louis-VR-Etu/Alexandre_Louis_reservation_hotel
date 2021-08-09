package controller;

import business.*;
import dataAccess.HotelDBAccess;
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

    public ApplicationController(){
        customerManager = new CustomerManager();
        hotelManager = new HotelManager();
        reservationManager = new ReservationManager();
        roomManager = new RoomManager();
        roomTypeManager= new RoomTypeManager();
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

    public ArrayList<Hotel> getHotels() throws HotelAccessException {
        try {
            return hotelManager.getHotels();
        }
        catch (HotelAccessException exception) {
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
/*
    public ArrayList<String> stringCustomer(ArrayList<Customer> customers) {
        return CustomerManager.stringCustomer(customers);
    }
*/
    public ArrayList<String> stringCustomerMail(ArrayList<Customer> customers) {
        return customerManager.stringCustomerMail(customers);
    }
    public ArrayList<String> stringReservation(ArrayList<Reservation> reservations) { return reservationManager.stringReservations(reservations);}

    public ArrayList<String> stringHotelNames(ArrayList<Hotel> hotels) { return hotelManager.stringHotelNames(hotels);}

    public ArrayList<String> stringRoomTypeNames(ArrayList<RoomType> roomTypeNames) { return roomTypeManager.stringRoomTypeNames(roomTypeNames); }
/*
    public City researchCity(String stringCity, ArrayList<City> cities) {
        return cityManager.researchCity(stringCity, cities);
    }

    public Station researchStation(String stringStation, ArrayList<Station> stations) {
        return stationManager.researchStation(stringStation, stations);
    }
*/
    public Reservation researchReservation(String reservationString, ArrayList<Reservation> reservations) {
        return reservationManager.researchReservation(reservationString, reservations);
    }

    public Room researchRoom(String roomString, ArrayList<Room> rooms){
        return roomManager.researchRoom(roomString, rooms);
    }

    public Hotel researchHotel(String hotelString, ArrayList<Hotel> hotels){
        return hotelManager.researchHotel(hotelString, hotels);
    }

    public Customer researchCustomer(String customerString, ArrayList<Customer> customers){
        return customerManager.researchCustomer(customerString, customers);
    }
/*
    public Employee researchEmployee(String employeeString, ArrayList<Employee> employees) {
        return employeeManager.researchEmployee(employeeString, employees);
    }

    public ArrayList<SubscriptionInfo> researchSubscription(Employee employee, Date dateDeb, Date dateFin) throws ResearchSubscriptionException{
        try {
            return employeeManager.researchSubscription(employee, dateDeb, dateFin);
        }
        catch (ResearchSubscriptionException exception) {
            throw exception;
        }
    }

    public ArrayList<MemberBikeInfo> researchMemberBike(String typeBikeChoosed) throws ResearchMemberBikeException{
        try {
            return memberManager.researchMemberBike(typeBikeChoosed);
        }
        catch (ResearchMemberBikeException exception) {
            throw exception;
        }
    }

    public ArrayList<RentingInfo> researchRenting(Member member, Date beginDate, Date enDate) throws ResearchRentingException{
        try {
            return rentingManager.researchRenting(member, beginDate, enDate);
        }
        catch (ResearchRentingException exception) {
            throw exception;
        }
    }

    public String jobTaskBikeCity(City city, Date beginDate, Date enDate) throws JobTaskCityException{
        try {
            return jobTaskManager.jobTaskBikeCity(city, beginDate, enDate);
        }
        catch (JobTaskCityException exception) {
            throw exception;
        }
    }

    public String jobTaskBikeStation(Station station, Date beginDate, Date enDate) throws JobTaskStationException{
        try {
            return jobTaskManager.jobTaskBikeStation(station, beginDate, enDate);
        }
        catch (JobTaskStationException exception) {
            throw exception;
        }
    }
*/
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
/*
    public String verifyCustomerMail(String customerMail) throws AddReservationException {
        try {
            return reservationManager.verifyCustomerMail(customerMail);
        } catch (AddReservationException exception) {
            throw exception;
        }
    }
 */
}
