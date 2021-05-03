package ru.icmit.oodb.lab13.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Realtor extends Person{

    private float amount_of_commission;

    @OneToMany
    private List<Client> clients;

    @OneToMany
    private List<Apartments> apartments;

    @OneToMany
    private List<Contract> contracts;

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

}
