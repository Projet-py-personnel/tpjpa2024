package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client extends Personne {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    public Client(String email, String name, String password) {
        super(email, name, password);
    }

    public Client() {}

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
