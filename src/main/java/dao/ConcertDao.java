package dao;

import domain.Concert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jpa.EntityManagerHelper;
import java.util.List;

public class ConcertDao {

    EntityManager manager = EntityManagerHelper.getEntityManager();

    // Méthode pour persister un concert
    public Concert save(Concert concert) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(concert);
        tx.commit();
        return concert;
    }

    // Méthode pour charger un concert par ID
    public Concert get(Long id) {
        return manager.find(Concert.class, id);
    }

    // Méthode pour récupérer une liste de concerts
    public List<Concert> get(List<Long> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Concert> get = cb.createQuery(Concert.class);
        Root<Concert> e = get.from(Concert.class);
        get.where(cb.in(e.get("id")).value(ids));
        List<Concert> concerts = manager.createQuery(get).getResultList();
        tx.commit();
        return concerts;
    }

    // Méthode pour récupérer tous les concerts
    public List<Concert> getAllConcerts() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaQuery<Concert> get = manager.getCriteriaBuilder().createQuery(Concert.class);
        Root<Concert> e = get.from(Concert.class);
        get.select(e);
        List<Concert> concerts = manager.createQuery(get).getResultList();
        tx.commit();
        return concerts;
    }

    // Méthode pour mettre à jour un concert (ex: titre)
    public void updateTitle(String newTitle, String oldTitle) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaUpdate<Concert> update = cb.createCriteriaUpdate(Concert.class);
        Root<Concert> e = update.from(Concert.class);
        update.set("title", newTitle);
        update.where(cb.equal(e.get("title"), oldTitle));
        manager.createQuery(update).executeUpdate();
        tx.commit();
    }

    // Méthode pour supprimer une liste de concerts
    public void delete(List<Long> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaDelete<Concert> delete = cb.createCriteriaDelete(Concert.class);
        Root<Concert> e = delete.from(Concert.class);
        delete.where(cb.in(e.get("id")).value(ids));
        manager.createQuery(delete).executeUpdate();
        tx.commit();
    }
}
