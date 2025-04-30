package dao;

import domain.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class PersonneDAO {

    private EntityManager entityManager;

    public PersonneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addPersonne(Personne personne) {
        entityManager.getTransaction().begin();
        entityManager.persist(personne);
        entityManager.getTransaction().commit();
    }

    public Personne getPersonneById(Long id) {
        return entityManager.find(Personne.class, id);
    }

    public List<Personne> getPersonnes(List<Long> ids) {
        TypedQuery<Personne> query = entityManager.createQuery(
                "SELECT p FROM Personne p WHERE p.id IN :ids", Personne.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    public List<Personne> getAllPersonnes() {
        TypedQuery<Personne> query = entityManager.createQuery("SELECT p FROM Personne p", Personne.class);
        return query.getResultList();
    }

    public void updatePersonne(Personne personne) {
        entityManager.getTransaction().begin();
        entityManager.merge(personne);
        entityManager.getTransaction().commit();
    }

    public void deletePersonne(List<Long> ids) {
        entityManager.getTransaction().begin();
        TypedQuery<Personne> query = entityManager.createQuery(
                "DELETE FROM Personne p WHERE p.id IN :ids", Personne.class);
        query.setParameter("ids", ids);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
