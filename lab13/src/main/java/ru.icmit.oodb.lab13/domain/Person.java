package ru.icmit.oodb.lab13.domain;

import javax.persistence.*;

//@MappedSuperclass //только классы-наследники
//@Entity@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //каждый класс отдельно
//@Entity@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //все поля в одном классе
@Entity@Inheritance(strategy = InheritanceType.JOINED) //класс объединяет в себе все персоны
public class Person extends AbstractEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person")
    @SequenceGenerator(name = "person", sequenceName = "person_seq", allocationSize=1)
    private int id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {

    }
}
