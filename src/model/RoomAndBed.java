package model;

public class RoomAndBed extends Room{
    private Integer singleBed;
    private Integer doubleBed;

    public RoomAndBed(Integer number, Integer floor, String hotelName, String roomType, int singleBed, int doubleBed) {
        super(number, floor, hotelName, roomType);
        this.singleBed = singleBed;
        this.doubleBed = doubleBed;
    }

    public RoomAndBed(Room room, RoomType roomType){
        this(room, roomType.getSingleBed(), roomType.getDoubleBed());
    }
    public RoomAndBed(Room room, int singleBed, int doubleBed){
        this(room.getNumber(), room.getFloor(), room.getHotelName(), room.getRoomType(), singleBed,doubleBed);
    }

    public Integer getSingleBed() {
        return this.singleBed;
    }
    public Integer getDoubleBed() {
        return this.doubleBed;
    }
}
