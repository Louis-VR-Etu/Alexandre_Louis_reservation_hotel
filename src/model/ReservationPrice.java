package model;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReservationPrice {
    private GregorianCalendar beginningDate;
    private GregorianCalendar endingDate;
    private int people;
    private boolean allInclusive;
    private int price;
    private int allInPrice;

    public ReservationPrice(GregorianCalendar beginningDate, GregorianCalendar endingDate, int people, boolean allInclusive, int price, int allInPrice){
        this.beginningDate =beginningDate;
        this.endingDate =endingDate;
        this.people = people;
        this.allInclusive = allInclusive;
        this.price = price;
        this.allInPrice = allInPrice;
    }
    public ReservationPrice(GregorianCalendar newBeginning, GregorianCalendar newEnding,Date beginningDate, Date endingDate, int people, boolean allInclusive, int price, int allInPrice){
        this.beginningDate = newBeginning;
        this.endingDate = newEnding;
        this.beginningDate.setTime(beginningDate);
        this.endingDate.setTime(endingDate);
        this.people = people;
        this.allInclusive = allInclusive;
        this.price = price;
        this.allInPrice = allInPrice;
    }

    public long getDuration() {
        return ChronoUnit.DAYS.between(beginningDate.toZonedDateTime(),endingDate.toZonedDateTime());

    }

    public int getPeople() {
        return people;
    }

    public boolean isAllInclusive() {
        return allInclusive;
    }

    public int getPrice() {
        return price;
    }

    public int getAllInPrice() {
        return allInPrice;
    }

}
