package ru.icmit.oodb.lab14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.icmit.oodb.lab14.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab14");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        AddressClient addressClient = new AddressClient();
        addressClient.setAddress("Копылова 1");
        AddressClient addressClient2 = new AddressClient();
        addressClient2.setAddress("Годовикова 2");
        List<AddressClient> addressClients = new ArrayList<AddressClient>();
        addressClients.add(addressClient);
        addressClients.add(addressClient2);

        entityManager.persist(addressClient);
        entityManager.persist(addressClient2);


        Apartments apartments = new Apartments("Maksimova 3", "Максим", 3000000);
        Apartments apartments2 = new Apartments("Kremlyovskaya 10", "Иван Иванов", 3000000);
        List<Apartments> apartmentsList = new ArrayList<Apartments>();
        apartmentsList.add(apartments);
        apartmentsList.add(apartments2);

        entityManager.persist(apartments);
        entityManager.persist(apartments2);

        Bank bank = new Bank();
        bank.setName("Сбербанк");

        entityManager.persist(bank);
        Client client = new Client();
        client.setFirstName("Alexey");
        client.setLastName("Alexeev");
        client.setEmail("Alexey@mail.ru");
        //many to one
        client.setBank(bank);
        //many to many
        client.setAddressesClients(addressClients);

        Client client2 = new Client();
        client2.setFirstName("Sergei");
        client2.setLastName("Sergeev");
        client2.setEmail("Sergei@mail.ru");
        //many to one
        client2.setBank(bank);
        //many to many
        client2.setAddressesClients(addressClients);


        List<Client> clients = new ArrayList<Client>();
        clients.add(client);
        clients.add(client2);

        entityManager.persist(client);
        entityManager.persist(client2);

        //One to one
        Contract contract = new Contract();
        contract.setApartments(apartments);
        contract.setClient(client);
        contract.setAmount(30000000);
        contract.setContractNumber(333333333);
        contract.setDateOfConclusion(new Date());

        entityManager.persist(contract);

        Realtor realtor = new Realtor("Иван", "Иванов", "+77777777777", "Ivan@mail.ru");
        //One to many
        realtor.setApartments(apartmentsList);
        //One to many
        realtor.setClients(clients);

        entityManager.persist(realtor);

        transaction.commit();
    }
}