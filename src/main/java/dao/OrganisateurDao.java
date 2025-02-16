package dao;

import domain.Organisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class OrganisateurDao {

    public Organisateur save(Organisateur organisateur) {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction t = manager.getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(organisateur);
        t.commit();
        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        return organisateur;

    }

}
