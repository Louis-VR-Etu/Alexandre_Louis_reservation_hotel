package controller;

import business.*;
import exception.*;
import model.*;

import java.util.ArrayList;
import java.util.Date;

public class ApplicationController {
    //business

    public ApplicationController(){

    }

    public void addMember(Reservation reservation) throws AddReservationException {
        try {
            reservationManager.addMember(reservation);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public void deleteMember(Reservation reservation) throws DeleteReservationException {
        try {
            reservationManager.deleteMember(reservation);
        }
        catch (DeleteReservationException exception) {
            throw exception;
        }
    }

    public void updateMember(Reservation reservation, Reservation reservationUpdated) throws UpdateReservationException {
        try {
            reservationManager.updateMember(reservation, reservationUpdated);
        }
        catch (UpdateReservationException exception) {
            throw exception;
        }
    }

    public ArrayList<Reservation> getMembers() throws GetReservationException {
        try{
            return reservationManager.getMembers();
        }
        catch (GetReservationException exception) {
            throw exception;
        }
    }
/*
    public ArrayList<City> getCities() throws CitiesAccessException {
        try {
            return cityManager.getCities();
        }
        catch (CitiesAccessException exception) {
            throw exception;
        }
    }

    public ArrayList<Employee> getEmployees() throws GetEmployeeException {
        try {
            return employeeManager.getEmployees();
        }
        catch (GetEmployeeException exception) {
            throw exception;
        }
    }

    public ArrayList<Station> getStations() throws GetStationException {
        try {
            return stationManager.getStations();
        }
        catch (GetStationException exception) {
            throw exception;
        }
    }

    public ArrayList<String> stringCity(ArrayList<City> cities) {
        return cityManager.stringCity(cities);
    }
*/
    public ArrayList<String> stringReservation(ArrayList<Reservation> reservations) { return reservationManager.stringMember(reservations);}
/*
    public ArrayList<String> stringEmployee(ArrayList<Employee> employees) { return employeeManager.stringEmployee(employees);}

    public ArrayList<String> stringStation(ArrayList<Station> stationsArray) { return stationManager.stringStation(stationsArray); }


    public City researchCity(String stringCity, ArrayList<City> cities) {
        return cityManager.researchCity(stringCity, cities);
    }

    public Station researchStation(String stringStation, ArrayList<Station> stations) {
        return stationManager.researchStation(stringStation, stations);
    }

    public Member researchMember(String memberString, ArrayList<Member> members) {
        return memberManager.researchMember(memberString, members);
    }

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
    public Date verifyBeginningDate(String day, String month, String year) throws AddReservationException {
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

    public Date verifyEndingDate(String day, String month, String year) throws AddReservationException {
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

    public Integer verifyCouponCode(String couponCode) throws AddReservationException {
        try {
            return reservationManager.verifyCouponCode(couponCode);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }

    public String verifyCustomerMail(String customerMail) throws AddReservationException {
        try {
            return reservationManager.verifyCustomerMail(customerMail);
        }
        catch (AddReservationException exception) {
            throw exception;
        }
    }


    }
}
