package dao;

import domain.Organisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class OrganisateurDAO {

    private EntityManager entityManager;

    public OrganisateurDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addOrganisateur(Organisateur organisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(organisateur);
        entityManager.getTransaction().commit();
    }

    public Organisateur getOrganisateurById(Long id) {
        return entityManager.find(Organisateur.class, id);
    }

    public List<Organisateur> getOrganisateurs(List<Long> ids) {
        TypedQuery<Organisateur> query = entityManager.createQuery(
                "SELECT o FROM Organisateur o WHERE o.id IN :ids", Organisateur.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    public List<Organisateur> getAllOrganisateurs() {
        TypedQuery<Organisateur> query = entityManager.createQuery("SELECT o FROM Organisateur o", Organisateur.class);
        return query.getResultList();
    }

    public void updateOrganisateur(Organisateur organisateur) {
        entityManager.getTransaction().begin();
        entityManager.merge(organisateur);
        entityManager.getTransaction().commit();
    }

    public void deleteOrganisateur(List<Long> ids) {
        entityManager.getTransaction().begin();
        TypedQuery<Organisateur> query = entityManager.createQuery(
                "DELETE FROM Organisateur o WHERE o.id IN :ids", Organisateur.class);
        query.setParameter("ids", ids);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}
