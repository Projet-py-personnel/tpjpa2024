package jpa;

import Service.TicketService;
import domain.Client;
import domain.Concert;
import domain.Ticket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	public JpaTest() {}

	public void addTicketToDatabase(Ticket ticket) {
		TicketService.addTicket(ticket);
	}

	public Ticket getTicketFromDatabase(Long id) {
		return TicketService.getTicketById(id);
	}

	public List<Ticket> getTicketsFromDatabase(Long buyerId) {
		return TicketService.getTicketsByBuyerId(buyerId);
	}

	public List<Ticket> getAllTickets() {
		return TicketService.getAllTickets();
	}

	public void updateTicketInDatabase(Ticket ticket) {
		TicketService.updateTicket(ticket);
	}

	public void deleteTicketFromDatabase(Long id) {
		TicketService.deleteTicket(id);
	}

	public static void main(String[] args) {

		JpaTest test = new JpaTest();
		Client client = new Client("client@gmail.com", "Client Name", "clientPassword");
		Concert concert = new Concert(); // Assurez-vous que l'objet concert soit bien initialisé
		Ticket ticket = new Ticket(client, concert, LocalDateTime.now(), "Carte bancaire");

		// Ajout d'un ticket à la base de données
		test.addTicketToDatabase(ticket);

		// Récupération d'un ticket à partir de son ID
		Ticket retrievedTicket = test.getTicketFromDatabase(ticket.getId());
		System.out.println("Ticket récupéré : " + retrievedTicket.getId());

		// Récupération de tous les tickets d'un client (par ID)
		List<Ticket> tickets = test.getTicketsFromDatabase(client.getId());
		for (Ticket t : tickets) {
			System.out.println("Ticket pour client " + t.getBuyer().getName());
		}

		// Mise à jour d'un ticket
		ticket.setPaymentMethod("Virement bancaire");
		test.updateTicketInDatabase(ticket);

		// Suppression d'un ticket
		test.deleteTicketFromDatabase(ticket.getId());

		System.out.println(".. done");
	}
}
