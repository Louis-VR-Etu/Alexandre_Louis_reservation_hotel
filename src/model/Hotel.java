package model;

public class Hotel {
    private String name;
    private String address;
    private Boolean animals;
    private Float allInclusivePrice;

    public String getName(){return name;}
    public String getAddress(){return address;}
    public Boolean getAnimals(){return animals;}
    public Float getAllInclusivePrice(){return allInclusivePrice;}

    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setAnimals(Boolean animals){this.animals = animals;}
    public void setAllInclusivePrice(Float allInclusivePrice){this.allInclusivePrice = allInclusivePrice;}

    public Hotel(String name, String address, Boolean animals, Float allInclusivePrice){
        this.name = name;
        this.address = address;
        this.animals = animals;
        this.allInclusivePrice = allInclusivePrice;
    }
}
