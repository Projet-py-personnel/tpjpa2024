package dao;

import domain.Organisateur;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class OrganisateurDao {

    public Organisateur save(Organisateur organisateur) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        EntityManagerHelper.getEntityManager().persist(organisateur);
        return organisateur;

    }

}
