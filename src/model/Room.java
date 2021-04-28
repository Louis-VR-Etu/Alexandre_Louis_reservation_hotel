package model;

public class Room {

    private Integer number;
    private String hotelName;
    private Integer floor;
    private String roomType;

    public Integer getFloor() {
        return floor;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }



    Room(Integer number, Integer floor, String hotelName, String roomType){
        this.number=number;
        this.floor=floor;
        this.roomType=roomType;
        this.hotelName=hotelName;
    }
}
