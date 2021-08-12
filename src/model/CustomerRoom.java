package model;

public class CustomerRoom {
    private String mail;
    private String name;
    private String surname;
    private String roomType;
    public CustomerRoom(String mail, String name, String surname, String roomType) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.roomType = roomType;
    }
    public String getRoomType(){
        return this.roomType;
    }
    public String getMail() {return this.mail;}
    public String getName(){return this.name;}
    public String getSurname(){return this.surname;}
}
