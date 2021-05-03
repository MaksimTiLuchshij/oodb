package ru.icmit.oodb.lab13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.icmit.oodb.lab13.domain.Client;
import ru.icmit.oodb.lab13.domain.Person;
import ru.icmit.oodb.lab13.domain.Realtor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab13");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Client client = new Client();
        client.setFirstName("Иван");
        client.setLastName("Иванов");
        client.setEmail("Ivan@mail.ru");
        client.setPhoneNumber("+77777777777");
        entityManager.persist(client);


//        Person person = new Person();
//        person.setFirstName("Alexey");
//        person.setLastName("Alexeev");
//        person.setPhoneNumber("+79999999999");
//        entityManager.persist(person);


        Realtor realtor = new Realtor();
        realtor.setFirstName("Петр");
        realtor.setLastName("Петров");
        realtor.setPhoneNumber("8-800-555-35-35");
        realtor.setAmount_of_commission(2);
        entityManager.persist(realtor);
//        entityManager.createQuery("select c from Person c").getResultList();

        transaction.commit();
    }
}