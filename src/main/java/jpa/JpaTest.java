package jpa;
import Service.ClientService;
import domain.Client;


public class JpaTest {




	public void addClientToDatabase(Client client) {

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
	public JpaTest() {

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {


		JpaTest test = new JpaTest();



		try {
			// TODO create and persist entity
			Client c= new Client("c1@gmail.com","c1","1234");
			test.addClientToDatabase(c);

		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println(".. done");
	}

}
