package dao;

import domain.Client;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class ClientDao {

    public Client save(Client client) {
        //EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

        EntityManagerHelper.getEntityManager().persist(client); //recupère l'entityManager actuellement dans le thread local
        return client;

    }

}
