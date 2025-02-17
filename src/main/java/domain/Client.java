package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hsqldb.rights.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
@Entity
@Table(name="clients")
public class Client extends Personne implements Serializable {
    /// les attributs de la classe
    /// préfèrera utiliser les anotations
    /// sur les méthodes plutôt que sur les attributs

    /// @JointTable( name= Client_ticket)
    /// cette ligne de code nous sera utile
    /// si on souhaite choisir nous meme le nom
    /// de notre table
    @OneToMany(cascade=ALL, mappedBy="buyer",fetch = FetchType.LAZY,orphanRemoval=true)
    private List<Ticket> tickets = new ArrayList<>();

    //constructeurs


    public Client(String email, String name, String password) {
        super(email, name, password);
    }

    public Client() {

    }


    ///  les méthodes de la classe

    /// 1- getAllTickets(), retourne
    /// tous les tickets achetés par le client
    /// actuel
    /// Un client peut avoir plusieurs Tickets
    /// Un ticket, au maximum 1 client
    /// the target entity class must not be specified because
    /// the collection is defined using generics
    /// If the relationship is bidirectional,
    ///  the mappedBy element must be used to specify
    /// the relationship field or property of the entity that is
    /// the owner of the relationship.


    public List<Ticket> getAllTickets() {
        return tickets;
    }
    /// 1- setTicket(),
    /// enregistre dans la classe
    /// les tickets achetés par le client
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
