package model;

public class RoomType {
    private String typeName;
    private Float price;
    private Integer singleBed;
    private Integer doubleBed;

    public void setTypeName(String typeName){
        this.typeName=typeName;
    }
    public void setPrice(Float price){
        this.price = price;
    }
    public void setSingleBed(Integer singleBed){
        this.singleBed = singleBed;
    }
     public void setDoubleBed(Integer doubleBed){
        this.doubleBed=doubleBed;
    }

    public String getTypeName(){
        return this.typeName;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getDoubleBed() {
        return doubleBed;
    }

    public Integer getSingleBed() {
        return singleBed;
    }
}
