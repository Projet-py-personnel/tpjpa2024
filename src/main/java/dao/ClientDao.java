package dao;
import domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jpa.EntityManagerHelper;
import java.util.List;

public class ClientDao {


    EntityManager manager = EntityManagerHelper.getEntityManager();

    /**
     * Persiste un client en bd
     * @param client
     * @return <code>client</code> qui a été persisté
     */
    public Client save(Client client) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        EntityManagerHelper.getEntityManager().persist(client);
        tx.commit();
        return client;
    }

    /**
     * Change le nom d'un utilisateur en bd
     * @param newName
     * @param oldName
     */
    public void updateName(String newName,String oldName) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        CriteriaUpdate<Client> update = cb.createCriteriaUpdate(Client.class);// create update
        Root<Client> e = update.from(Client.class);// set the root class
        update.set("name", newName);//set update and where clause
        update.where(cb.equal(e.get("name"), oldName));
        Query query = manager.createQuery(update);
        query.executeUpdate();
        tx.commit();
    }

    /**
     * Supprime une liste de clients en bd
     * Peut aussi supprimer un seul
     * @param ids la liste des identifiants
     * des clients à supprimer
     */
    public void delete(List<Integer> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        CriteriaDelete<Client> delete = cb.createCriteriaDelete(Client.class);// create delete
        Root<Client> e = delete.from(Client.class);// set the root class
        delete.where(cb.in(e.get("id")).value(ids));// set where clause
        this.manager
                .createQuery(delete)
                .setHint("id", "client")
                .executeUpdate(); // perform delete
        tx.commit();
    }

    /**
     * Charge une liste de clients depuis la bd
     * Peut aussi charger un seul
     * @param ids la liste des identifiants
     * des clients à extraire
     */
    public List<Client> get(List<Integer> ids) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        CriteriaQuery<Client> get = cb.createQuery(Client.class);
        Root<Client> e = get.from(Client.class);
        get.where(cb.in(e.get("id")).value(ids));
        List<Client> posts = manager
                .createQuery(get)
                .setHint("id", "client")
                .getResultList();
        tx.commit();
        return posts;
    }

    /**
     * Charge tous les clients depuis la bd
     */
    public List<Client> getAllClients() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        CriteriaQuery<Client> get = cb.createQuery(Client.class);
        Root<Client> e = get.from(Client.class);
        get.select(e);// match the entire root table to the get query
        List<Client> table_content= manager.createQuery(get).getResultList();
        tx.commit();
        return table_content;
    }

}





