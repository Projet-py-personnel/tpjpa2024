package Service;

import domain.Concerts;
import domain.Roles;
import domain.Tickets;
import domain.Users;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;

public class ConcertsService {

    private EntityManager manager;

    public ConcertsService(EntityManager manager) {
        this.manager = manager;
    }
    // Ajouter un concert avec un organisateur
    public void addConcert(int capacity, LocalDateTime date, String description, Long id, String location, Users organizer, Double price , String title, List<Tickets> tickets) {
            Users organize = manager.find(Users.class, id);
        if (organize != null && organize.getRole() == Roles.ORGANIZER) {
            Concerts concert = new Concerts(capacity, date,description, location, organizer, price , title, tickets);
            manager.persist(concert);
        } else {
            System.out.println("Organisateur non trouvé ou rôle invalide !");
        }
    }

}
