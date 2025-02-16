package jpa;
import Service.ClientService;
import domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {

	private EntityManager manager;


	public void addClientToDatabase(ClientService clientService) {
		// Ajouter des utilisateurs
		Client client = new Client();
		client.setName("aline");
		client.setEmail("bob@mail.com");
		ClientService.addClient(client);
	}
	public void addAdministrateurToDatabase(ClientService usersService) {
		// Ajouter des admins en db
	}
	public void addConcertToDatabase(ClientService usersService) {
		// Ajouter des admins en db
	}
	public void addOrganisateurToDatabase(ClientService usersService) {
		// Ajouter des admins en db
	}
	public void addPersonneToDatabase(ClientService usersService) {
		// Ajouter des admins en db
	}
	public void addTicketToDatabase(ClientService usersService) {
		// Ajouter des admins en db
	}
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			// TODO create and persist entity
			ClientService clientService = new ClientService();
			test.addClientToDatabase(clientService);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
