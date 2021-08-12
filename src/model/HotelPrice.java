package model;

public class HotelPrice {
    private String hotelName;
    private String address;
    private String roomType;
    private Integer price;

    public HotelPrice(String hotelName, String address, String roomType, int price){
        this.address=address;
        this.hotelName = hotelName;
        this.price=price;
        this.roomType = roomType;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPrice() {
        return price;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getRoomType() {
        return roomType;
    }
}
