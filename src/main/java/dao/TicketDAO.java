package dao;

import domain.Client;
import domain.Concert;
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
        try {
            // Vérification que le client existe en base
            Client buyer = ticket.getBuyer();
            if (buyer.getId() == null || entityManager.find(Client.class, buyer.getId()) == null) {
                entityManager.persist(buyer);  // Persiste un nouveau client si l'ID n'existe pas
            } else {
                buyer = entityManager.merge(buyer); // Si le client existe, on rattache l'entité persistée
            }
            ticket.setBuyer(buyer);  // Associe l'acheteur au ticket

            // Vérification que le concert existe en base
            Concert concert = ticket.getConcert();
            if (concert.getId() == null || entityManager.find(Concert.class, concert.getId()) == null) {
                entityManager.persist(concert);  // Persiste un nouveau concert si l'ID n'existe pas
            } else {
                concert = entityManager.merge(concert);  // Rattache le concert existant
            }
            ticket.setConcert(concert);  // Associe le concert au ticket

            // Persiste le ticket
            entityManager.persist(ticket);

            // Commit de la transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Si une erreur survient, rollback de la transaction
            entityManager.getTransaction().rollback();
            throw e;  // Rejette l'exception pour gestion ultérieure
        }
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
        try {
            entityManager.merge(ticket);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteTicket(Long id) {
        entityManager.getTransaction().begin();
        try {
            Ticket ticket = entityManager.find(Ticket.class, id);
            if (ticket != null) {
                entityManager.remove(ticket);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
