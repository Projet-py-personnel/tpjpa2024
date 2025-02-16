package dao;

import domain.Administrateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class AdminDao {

    public Administrateur save(Administrateur admin) {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction t = manager.getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(admin);
        t.commit();
        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        return admin;
    }
}
