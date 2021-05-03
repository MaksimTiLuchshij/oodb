package ru.icmit.oodb.lab15.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartments")
@Entity
public class Apartments {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Apartments")
    @SequenceGenerator(name = "Apartments", sequenceName = "apartments_seq", allocationSize = 1)
    @Id
    private Integer id;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
