package dao;

import domain.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TicketDAO {

    private EntityManager entityManager;

    public TicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addTicket(Ticket ticket) {
        entityManager.getTransaction().begin();
        entityManager.persist(ticket);
        entityManager.getTransaction().commit();
    }

    public Ticket getTicketById(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    public List<Ticket> getTicketsByBuyerId(Long buyerId) {
        TypedQuery<Ticket> query = entityManager.createQuery(
                "SELECT t FROM Ticket t WHERE t.buyer.id = :buyerId", Ticket.class);
        query.setParameter("buyerId", buyerId);
        return query.getResultList();
    }

    public List<Ticket> getAllTickets() {
        TypedQuery<Ticket> query = entityManager.createQuery("SELECT t FROM Ticket t", Ticket.class);
        return query.getResultList();
    }

    public void updateTicket(Ticket ticket) {
        entityManager.getTransaction().begin();
        entityManager.merge(ticket);
        entityManager.getTransaction().commit();
    }

    public void deleteTicket(Long id) {
        entityManager.getTransaction().begin();
        Ticket ticket = entityManager.find(Ticket.class, id);
        if (ticket != null) {
            entityManager.remove(ticket);
        }
        entityManager.getTransaction().commit();
    }
}
