package ru.icmit.oodb.lab14.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Realtor {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Realtor")
    @SequenceGenerator(name = "Realtor", sequenceName = "realtor_seq", allocationSize = 1)
    @Id
    private Integer id;

    private float amount_of_commission;

    @OneToMany
    private List<Client> clients;

    @OneToMany
    private List<Apartments> apartments;

    @OneToMany
    private List<Contract> contracts;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    public Realtor(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Realtor(){}

    public void setAmount_of_commission(float amount_of_commission){
        this.amount_of_commission = amount_of_commission;
    }

    public void setClients(List<Client> clients){
        this.clients = clients;
    }

    public void setApartments(List<Apartments> apartments){
        this.apartments = apartments;
    }
    public void setContracts(List<Contract> contracts){
        this.contracts = contracts;
    }

    public List<Client> getClients(){return clients;}

    public List<Apartments> getApartments(){return apartments;}

    public List<Contract> getContracts(){return contracts;}
    public float getAmount_of_commission(){
        return amount_of_commission;
    }

    public void addContract(long number, Apartments apartment, Client client){
        float endPrice = apartment.getPrice() + amount_of_commission*apartment.getPrice()/100;
        Contract contract = new Contract(number,new Date(),endPrice, client, apartment);
        contracts.add(contract);
        apartments.remove(apartment);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return
                "firstName='" + getFirstName() + '\'' +
                        ", lastName='" + getLastName() + '\'' +
                        ", phoneNumber='" + getPhoneNumber() + '\'' +
                        ", email='" + getEmail() + '\'' +
                        '}';
    }
}
