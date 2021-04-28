package model;

import java.util.GregorianCalendar;

public class Reservation {
    private GregorianCalendar beginningDate;
    private Integer roomNumber;
    private String hotelName;
    private GregorianCalendar endingDate;
    private Boolean allInclusive;
    private Integer people;
    private String title;
    private String additionalContact;
    private String couponCode;
    private String customerMail;

    public GregorianCalendar getBeginningDate(){return beginningDate;}
    public Integer getRoomNumber(){return roomNumber;}
    public String getHotelName(){return hotelName;}
    public GregorianCalendar getEndingDate(){return endingDate;}
    public Boolean getAllInclusive(){return allInclusive;}
    public Integer getPeople(){return people;}
    public String getTitle(){return title;}
    public String getAdditionalContact(){return additionalContact;}
    public String getCouponCode(){return couponCode;}
    public String getCustomerMail(){return customerMail;}

    public void setBeginningDate(GregorianCalendar beginningDate){this.beginningDate = beginningDate;}
    public void setRoomNumber(Integer roomNumber){this.roomNumber = roomNumber;}
    public void setHotelName(String hotelName){this.hotelName = hotelName;}
    public void setEndingDate(GregorianCalendar endingDate){this.endingDate = endingDate;}
    public void setAllInclusive(Boolean allInclusive){this.allInclusive = allInclusive;}
    public void setPeople(Integer people){this.people = people;}
    public void setTitle(String title){this.title = title;}
    public void setAdditionalContact(String additionalContact){this.additionalContact = additionalContact;}
    public void setCouponCode(String couponCode){this.couponCode = couponCode;}
    public void setCustomerMail(String customerMail){this.customerMail = customerMail;}

    public Reservation(GregorianCalendar beginningDate, Integer roomNumber, String hotelName, GregorianCalendar endingDate, Boolean allInclusive, Integer people, String title, String additionalContact, String couponCode, String customerMail){
        this.beginningDate = beginningDate;
        this.roomNumber = roomNumber;
        this.hotelName = hotelName;
        this.endingDate = endingDate;
        this.allInclusive = allInclusive;
        this.people = people;
        this.title = title;
        this.additionalContact = additionalContact;
        this.couponCode = couponCode;
        this.customerMail = customerMail;
    }

    public Reservation(GregorianCalendar beginningDate, Integer roomNumber, String hotelName, GregorianCalendar endingDate, Boolean allInclusive, Integer people, String title, String customerMail){
        this(beginningDate, roomNumber, hotelName, endingDate, allInclusive, people, title, null, null, customerMail);
    }
}
