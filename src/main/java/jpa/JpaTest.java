package jpa;

import Service.ConcertService;
import Service.AdministrateurService;
import Service.ClientService;
import Service.OrganisateurService;
import Service.PersonneService;
import domain.Concert;
import domain.Administrateur;
import domain.Client;
import domain.Organisateur;
import domain.Personne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	public JpaTest() {}

	/**************************** Méthodes pour les Concerts **********************************/

	public void addConcertToDatabase(Concert concert) {
		ConcertService.addConcert(concert);
	}

	public Concert getConcertFromDatabase(Long id) {
		return ConcertService.getConcert(id);
	}

	public List<Concert> getConcertsFromDatabase(List<Long> ids) {
		return ConcertService.getConcerts(ids);
	}

	public List<Concert> getAllConcerts() {
		return ConcertService.getAllConcerts();
	}

	public void updateConcertOfDatabase(String newTitle, String oldTitle) {
		ConcertService.updateTitle(newTitle, oldTitle);
	}

	public void deleteConcertFromDatabase(List<Long> ids) {
		ConcertService.deleteConcert(ids);
	}

	/**************************** Méthodes pour les Clients **********************************/

	public void addClientToDatabase(Client client) {
		ClientService.addClient(client);
	}

	public List<Client> getClientsFromDatabase(List<Integer> ids) {
		return ClientService.getClient(ids);
	}

	public List<Client> getAllClients() {
		return ClientService.getAllClients();
	}

	public void updateClientOfDatabase(String newName, String oldName) {
		ClientService.updateName(newName, oldName);
	}

	public void deleteClientFromDatabase(List<Integer> ids) {
		ClientService.deleteClient(ids);
	}

	/**************************** Méthodes pour les Administrateurs **********************************/

	public void addAdministrateurToDatabase(Administrateur admin) {
		AdministrateurService.addAdministrateur(admin);
	}

	public List<Administrateur> getAdministrateursFromDatabase(List<Integer> ids) {
		return AdministrateurService.getAdministrateurs(ids);
	}

	public List<Administrateur> getAllAdministrateurs() {
		return AdministrateurService.getAllAdministrateurs();
	}

	public void updateAdministrateurOfDatabase(String newName, String oldName) {
		AdministrateurService.updateName(newName, oldName);
	}

	public void deleteAdministrateurFromDatabase(List<Integer> ids) {
		AdministrateurService.deleteAdministrateur(ids);
	}

	/**************************** Méthodes pour les Organisateurs **********************************/

	public void addOrganisateurToDatabase(Organisateur organisateur) {
		OrganisateurService.addOrganisateur(organisateur);
	}

	public List<Organisateur> getOrganisateursFromDatabase(List<Long> ids) {
		return OrganisateurService.getOrganisateurs(ids);
	}

	public List<Organisateur> getAllOrganisateurs() {
		return OrganisateurService.getAllOrganisateurs();
	}

	public void updateOrganisateurOfDatabase(Organisateur organisateur) {
		OrganisateurService.updateOrganisateur(organisateur);
	}

	public void deleteOrganisateurFromDatabase(List<Long> ids) {
		OrganisateurService.deleteOrganisateur(ids);
	}

	/**************************** Méthodes pour les Personnes **********************************/

	public void addPersonneToDatabase(Personne personne) {
		PersonneService.addPersonne(personne);
	}

	public List<Personne> getPersonnesFromDatabase(List<Long> ids) {
		return PersonneService.getPersonnes(ids);
	}

	public List<Personne> getAllPersonnes() {
		return PersonneService.getAllPersonnes();
	}

	public void updatePersonneOfDatabase(Personne personne) {
		PersonneService.updatePersonne(personne);
	}

	public void deletePersonneFromDatabase(List<Long> ids) {
		PersonneService.deletePersonne(ids);
	}

	/**************************** Test des Concerts et autres entités **********************************/
	public static void main(String[] args) {

		JpaTest test = new JpaTest();

		// Création de quelques concerts
		Concert c1 = new Concert("Concert 1", LocalDateTime.now(), "Lieu 1", "Artiste 1", LocalDateTime.now().plusHours(2));
		Concert c2 = new Concert("Concert 2", LocalDateTime.now().plusDays(1), "Lieu 2", "Artiste 2", LocalDateTime.now().plusDays(1).plusHours(2));
		Concert c3 = new Concert("Concert 3", LocalDateTime.now().plusDays(2), "Lieu 3", "Artiste 3", LocalDateTime.now().plusDays(2).plusHours(2));

		// Persistance des concerts
		test.addConcertToDatabase(c1);
		test.addConcertToDatabase(c2);
		test.addConcertToDatabase(c3);

		// Extraction de concerts par IDs
		List<Long> concertIds = new ArrayList<>();
		concertIds.add(1L);
		concertIds.add(2L);
		concertIds.add(3L);
		List<Concert> concertsResult = test.getConcertsFromDatabase(concertIds);
		for (Concert c : concertsResult) {
			System.out.println("Concert trouvé: " + c.getTitle());
		}

		// Création et persistance d'un organisateur
		Organisateur org = new Organisateur("Organisateur 1", "Contact 1", "Email 1");
		test.addOrganisateurToDatabase(org);

		// Extraction d'organisateur
		List<Long> organisateurIds = new ArrayList<>();
		organisateurIds.add(1L);
		List<Organisateur> organisateurs = test.getOrganisateursFromDatabase(organisateurIds);
		for (Organisateur o : organisateurs) {
			System.out.println("Organisateur trouvé: " + o.getName());
		}

		// Création et persistance d'une personne
		Personne p1 = new Personne("Personne 1", "Email 1","1234");
		test.addPersonneToDatabase(p1);

		// Extraction de personne
		List<Long> personneIds = new ArrayList<>();
		personneIds.add(1L);
		List<Personne> personnes = test.getPersonnesFromDatabase(personneIds);
		for (Personne p : personnes) {
			System.out.println("Personne trouvée: " + p.getName());
		}

		// Mise à jour du titre d'un concert
		test.updateConcertOfDatabase("Nouveau Titre", "Concert 1");

		// Suppression d'un concert
		List<Long> idsToDeleteConcert = new ArrayList<>();
		idsToDeleteConcert.add(1L);
		test.deleteConcertFromDatabase(idsToDeleteConcert);

		// Mise à jour d'un organisateur
		org.setName("Organisateur Mis à Jour");
		test.updateOrganisateurOfDatabase(org);

		// Suppression d'un organisateur
		List<Long> idsToDeleteOrganisateur = new ArrayList<>();
		idsToDeleteOrganisateur.add(1L);
		test.deleteOrganisateurFromDatabase(idsToDeleteOrganisateur);

		// Mise à jour d'une personne
		p1.setName("Personne Mise à Jour");
		test.updatePersonneOfDatabase(p1);

		// Suppression d'une personne
		List<Long> idsToDeletePersonne = new ArrayList<>();
		idsToDeletePersonne.add(1L);
		test.deletePersonneFromDatabase(idsToDeletePersonne);

		System.out.println(".. done");
	}
}
