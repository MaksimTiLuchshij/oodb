package ru.icmit.oodb.lab15.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @JoinColumn(name = "bank_fk")
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Bank bank;
    @JoinTable(name = "client_addresses",joinColumns = @JoinColumn(name = "client_id"),inverseJoinColumns = @JoinColumn(name = "clientsAd_id"))
    @ManyToMany
    private List<AddressClient> addressesClients;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Client")
    @SequenceGenerator(name = "Client", sequenceName = "client_seq", allocationSize = 1)
    private Integer id;

    public Client(String firstName, String lastName, String phoneNumber, String email, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bank = bank;
    }
    public Client(){}

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

    public List<AddressClient> getAddressesClients() {
        return addressesClients;
    }

    public void setAddressesClients(List<AddressClient> addressesClients) {
        this.addressesClients = addressesClients;
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

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

    public Bank getBank(){
        return bank;
    }
}
