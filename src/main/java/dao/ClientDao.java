package dao;

import Service.ClientService;
import domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import jpa.EntityManagerHelper;

import java.util.List;


public class ClientDao {
    EntityManager manager = EntityManagerHelper.getEntityManager();

    public Client save(Client client) {
        //EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        EntityManagerHelper.getEntityManager().persist(client); //recupère l'entityManager actuellement dans le thread local
        tx.commit();
        return client;

    }
    public void updateName(String newName,String oldName) {
        //EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
               // create update
        CriteriaUpdate<Client> update = cb.
                createCriteriaUpdate(Client.class);
        // set the root class
        Root e = update.from(Client.class);
        // set update and where clause
        update.set("name", newName);
        update.where(cb.equal(e.get("name"), oldName));
        Query query = manager.createQuery(update);
        int result = query.executeUpdate();
        tx.commit();
        // essayer de trouver la bonne formule pour cette méthode
        //retrouver le client par son id
        //et etre capable de changer tous les attributs qu'elle veut

    }
    public void delete(List<Integer> ids) {



        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();

        // create delete
        CriteriaDelete<Client> delete = cb.
                createCriteriaDelete(Client.class);

        // set the root class
        Root e = delete.from(Client.class);

        // set where clause
        delete.where(
                cb.in(
                        e.get("id")).value(ids)
        );

        // perform update
        this.manager
                .createQuery(delete)
                .setHint("id", "client")
                .executeUpdate();
        tx.commit();


    }

    public List<Client> get(List<Integer> ids) {


        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        // create get query
        CriteriaQuery<Client> get = cb.createQuery(Client.class);
        // set the root class

        Root e = get.from(Client.class);
        // set where clause
        get.where(
                cb.in(
                        e.get("id")).value(ids)
        );
        List<Client> posts = manager
                .createQuery(get)
                .setHint("id", "client")
                .getResultList();
        tx.commit();
        return posts;
    }
    public List<Client> getAllClients() {


        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        CriteriaBuilder cb = this.manager.getCriteriaBuilder();
        // create get query
        CriteriaQuery<Client> get = cb.createQuery(Client.class);
        // set the root class

        Root e = get.from(Client.class);

        // match the entire root( table to the query get )
        get.select(e);
        //execute the query
        List<Client> table_content= manager.createQuery(get).getResultList();

        tx.commit();
        return table_content;
    }

}
;




