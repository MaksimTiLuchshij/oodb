package ru.icmit.oodb.lab15;

import ru.icmit.oodb.lab15.DbWork;
import ru.icmit.oodb.lab15.domain.Bank;
import ru.icmit.oodb.lab15.domain.Client;
import ru.icmit.oodb.lab15.domain.Realtor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

public class Lab15Main {

    public static void main(String[] args) {
        DbWork db = DbWork.getInstance();

        EntityManager entityManager = db.getEmManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //Many to one без каскадных операций
        Client client = new Client("Maksim", "Mineev", "+77777777777", "Min-max2000@mail.ru", null);
        Client client2 = new Client("Andrey", "Andreev", "+78888888888", "Andrei2000@mail.ru", null);

        Bank bank = new Bank();
        bank.setName("Сбербанк");

        client.setBank(bank);
        client2.setBank(bank);

        //Сохранение без каскадных операций
        entityManager.persist(bank);
        entityManager.persist(client);
        entityManager.persist(client2);
        //Обновление без использования каскадных операций. Но обновление работает и без этой строчки
        bank.setName("Альфабанк");
        entityManager.merge(bank);
        //Удаление без использования каскадных операций
        entityManager.remove(client);
        entityManager.remove(client2);

//        //Many to one с каскадными операциями
//        Client client = new Client("Maksim", "Mineev", "+77777777777", "Min-max2000@mail.ru", null);
//        Client client2 = new Client("Andrey", "Andreev", "+78888888888", "Andrei2000@mail.ru", null);
//
//        Bank bank = new Bank();
//        bank.setName("Сбербанк");
//
//        client.setBank(bank);
//        client2.setBank(bank);
//
//        //Сохранение с каскадными операциями
//        entityManager.persist(client);
//        entityManager.persist(client2);
//        //Обновление с использованием каскадных операций
//        bank.setName("Альфабанк");
//        //Удаление с  каскадными операциями
//        entityManager.remove(client);
//        entityManager.remove(client2);





//                //One to many с каскадными операциями
//        Client client = new Client("Maksim", "Mineev", "+77777777777", "Min-max2000@mail.ru", null);
//        Client client2 = new Client("Andrey", "Andreev", "+78888888888", "Andrei2000@mail.ru", null);
//
//        Realtor realtor = new Realtor("Lev", "Lvovich", "88005553535", null);
//
//
//        ArrayList<Client> clients = new ArrayList<>();
//        clients.add(client);
//        clients.add(client2);
//
//        realtor.setClients(clients);
//
//        //Сохранение без каскадных операций
//        entityManager.persist(client);
//        entityManager.persist(client2);
//        entityManager.persist(realtor);
//
//        //Обновление без каскадных операций
//        client.setEmail("1234@mail.ru");
//        entityManager.merge(client);
//        //Удаление без каскадных операций
////        entityManager.remove(client);
////        entityManager.remove(client2);
////        entityManager.remove(realtor);








//        //One to many с каскадными операциями
//        Client client = new Client("Maksim", "Mineev", "+77777777777", "Min-max2000@mail.ru", null);
//        Client client2 = new Client("Andrey", "Andreev", "+78888888888", "Andrei2000@mail.ru", null);
//
//        Realtor realtor = new Realtor("Lev", "Lvovich", "88005553535", null);
//
//
//        ArrayList<Client> clients = new ArrayList<>();
//        clients.add(client);
//        clients.add(client2);
//
//        realtor.setClients(clients);
//
//        //Сохранение с каскадными операциями
//        entityManager.persist(realtor);
//
//        //Обновление с использованием каскадных операций
//        client.setEmail("1234@mail.ru");
//
//        //Удаление с  каскадными операциями
////        entityManager.remove(realtor);



        transaction.commit();
        db.closeEntityManager();

        DbWork.clear();
    }
}
