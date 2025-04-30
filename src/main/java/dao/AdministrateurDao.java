package dao;

import domain.Administrateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jpa.EntityManagerHelper;

import java.util.List;

public class AdministrateurDao {

    EntityManager manager = EntityManagerHelper.getEntityManager();

    /**
     * Persiste un administrateur en bd
     * @param admin
     * @return <code>admin</code> qui a été persisté
     */
    public Administrateur save(Administrateur admin) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(admin);
        tx.commit();
        return admin;
    }

    /**
     * Change le nom d'un administrateur
     * @param newName le nouveau nom
     * @param oldName l'ancien nom
     */
    public void updateName(String newName, String oldName) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaUpdate<Administrateur> update = cb.createCriteriaUpdate(Administrateur.class);
        Root<Administrateur> e = update.from(Administrateur.class);
        update.set("name", newName);
        update.where(cb.equal(e.get("name"), oldName));
        Query query = manager.createQuery(update);
        query.executeUpdate();
        tx.commit();
    }

    /**
     * Supprime une liste d'administrateurs
     * @param ids liste des identifiants à supprimer
     */
    public void delete(List<Integer> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaDelete<Administrateur> delete = cb.createCriteriaDelete(Administrateur.class);
        Root<Administrateur> e = delete.from(Administrateur.class);
        delete.where(cb.in(e.get("id")).value(ids));
        manager.createQuery(delete).executeUpdate();
        tx.commit();
    }

    /**
     * Récupère une liste d'administrateurs par ID
     * @param ids liste des identifiants à récupérer
     * @return liste des administrateurs
     */
    public List<Administrateur> get(List<Integer> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Administrateur> get = cb.createQuery(Administrateur.class);
        Root<Administrateur> e = get.from(Administrateur.class);
        get.where(cb.in(e.get("id")).value(ids));
        List<Administrateur> result = manager.createQuery(get).getResultList();
        tx.commit();
        return result;
    }

    /**
     * Récupère tous les administrateurs
     * @return liste de tous les administrateurs
     */
    public List<Administrateur> getAllAdministrateurs() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Administrateur> get = cb.createQuery(Administrateur.class);
        Root<Administrateur> e = get.from(Administrateur.class);
        get.select(e);
        List<Administrateur> result = manager.createQuery(get).getResultList();
        tx.commit();
        return result;
    }
}
