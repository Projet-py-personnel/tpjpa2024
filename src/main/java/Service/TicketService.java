package Service;

import dao.TicketDAO;
import domain.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class TicketService {

    private static TicketDAO ticketDAO;
    private static EntityManager entityManager;

    static {
        entityManager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
        ticketDAO = new TicketDAO(entityManager);
    }

    public static void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }

    public static Ticket getTicketById(Long id) {
        return ticketDAO.getTicketById(id);
    }

    public static List<Ticket> getTicketsByBuyerId(Long buyerId) {
        return ticketDAO.getTicketsByBuyerId(buyerId);
    }

    public static List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    public static void updateTicket(Ticket ticket) {
        ticketDAO.updateTicket(ticket);
    }

    public static void deleteTicket(Long id) {
        ticketDAO.deleteTicket(id);
    }
}
