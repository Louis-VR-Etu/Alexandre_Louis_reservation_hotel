package model;

import java.util.GregorianCalendar;

public class Customer {
    private String mail;
    private String name;
    private String surname;
    private GregorianCalendar birthDate;
    private String phoneNumber;

    public String getMail(){return mail;}
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public GregorianCalendar getBirthDate(){return birthDate;}
    public String getPhoneNumber(){return phoneNumber;}

    public void setMail(String mail){this.mail = mail;}
    public void setName(String name){this.name = name;}
    public void setSurname(String surname){this.surname = surname;}
    public void setBirthDate(GregorianCalendar birthDate){this.birthDate = birthDate;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

    public Customer(String mail, String name, String surname, GregorianCalendar birthDate, String phoneNumber){
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this. phoneNumber = phoneNumber;
    }
}
