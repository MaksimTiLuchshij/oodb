package ru.icmit.oodb.lab13.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class EstateAgency {
    @Id
    private String id;

    private String name;

    public EstateAgency(String name) {
        this.name = name;
    }
    public EstateAgency(){}

    @OneToMany
    private List<Realtor> realtors;

    public void setName(String name){
        this.name = name;
    }

    public void setRealtors(List<Realtor> realtors){
        this.realtors = realtors;
    }


    public List<Realtor> getRealtors(){
        return realtors;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Estate agency: " + getName() +
                ", realtors=" + realtors +
                '\n';
    }
    public String getValue() {
        return "('" + name + "')";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}