package ru.icmit.oodb.lab13.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;


@Entity
public class Contract {
    @Id
    private String id;

    private long contractNumber;

    private Date dateOfConclusion;

    private float amount;
    @OneToOne
    private Client client;
    @OneToOne
    private Apartments apartments;


    public Contract(long number, Date dateOfConclusion, float amount, Client client, Apartments apartments ){
        this.contractNumber = number;
        this.dateOfConclusion = dateOfConclusion;
        this.amount = amount;
        this.client = client;
        this.apartments = apartments;
    }
    public Contract(){}

    public void setContractNumber(long contractNumber){
        this.contractNumber = contractNumber;
    }
    public long getContractNumber(){
        return contractNumber;
    }
    public void setDateOfConclusion(Date dateOfConclusion){
        this.dateOfConclusion = dateOfConclusion;
    }
    public Date getDateOfConclusion(){
        return dateOfConclusion;
    }
    public void setAmount(float amount){
        this.amount = amount;
    }
    public float getAmount(){
        return amount;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Apartments getApartments() {
        return apartments;
    }

    public void setApartments(Apartments apartments) {
        this.apartments = apartments;
    }


    @Override
    public String toString() {
        return
                "name ='" + client.getFirstName() + '\'' +
                "lastname='" + client.getLastName() + '\'' +
                "Owner's name ='" + apartments.getOwner() + '\'' +
                "Date of conclusion='" + dateOfConclusion + '\'' +
                "amount='" + amount + '\'' +
                '}';
    }
    public String getValue() {
        return "('" + contractNumber + "','" + amount + "','" + apartments + "')";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
