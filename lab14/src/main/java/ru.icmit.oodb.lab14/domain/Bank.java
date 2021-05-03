package ru.icmit.oodb.lab14.domain;

import javax.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Bank")
    @SequenceGenerator(name = "Bank", sequenceName = "bank_seq", allocationSize = 1)
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
