package Service;

import domain.Roles;
import domain.Users;
import jakarta.persistence.EntityManager;

public class ConcertsService {

    private EntityManager manager;

    public ConcertsService(EntityManager manager) {
        this.manager = manager;
    }
    // Ajouter un concert avec un organisateur
   /** public void addConcert(int capacity, LocalDateTime date, String description, Long id, String location, Users organizer, Double price ,String title, List<Tickets> tickets) {
            Users organizer = manager.find(Users.class, id);
        if (organizer != null && organizer.getRole() == Roles.ORGANIZER) {
            Concerts concert = new Concerts(capacity, date,description, location, organizer, price , title, tickets);
            manager.persist(concert);
        } else {
            System.out.println("Organisateur non trouvé ou rôle invalide !");
        }
    }**/

}
