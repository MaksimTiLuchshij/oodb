package ru.icmit.oodb.lab13.domain;

import javax.persistence.Entity;


@Entity
public class Client extends Person{
    private String email;
    public Client(){}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
