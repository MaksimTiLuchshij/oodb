package ru.icmit.oodb.lab13.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apartments {
    @Id
    private int id;

    private String address;

    private String owner;

    private float price;


    public Apartments(String address, String owner, float price){
        this.address = address;
        this.price = price;
    }
    public Apartments(){}
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }
    public String getOwner(){
        return owner;
    }

    public String getValue() {
        return "('" + address + "','" + owner + "','" + price + "')";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
