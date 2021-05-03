package ru.icmit.oodb.lab14.domain;

import javax.persistence.*;

@Entity
public class AddressClient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddressClient")
    @SequenceGenerator(name = "AddressClient", sequenceName = "addressClient_seq", allocationSize = 1)
    private int id;

    private String address;

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }
}
