package dao;

import domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class ClientDao {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public Client save(Client client) {
        //EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        EntityManagerHelper.getEntityManager().persist(client); //recupère l'entityManager actuellement dans le thread local
        tx.commit();
        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        return client;

    }

}
