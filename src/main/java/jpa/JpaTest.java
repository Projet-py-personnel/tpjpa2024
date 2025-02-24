package jpa;
import Service.ClientService;
import domain.Client;

import java.util.ArrayList;
import java.util.List;


public class JpaTest {




	public void addClientToDatabase(Client client) {

		ClientService.addClient( client);
	}
	public List<Client> getClientsFromDatabase(List<Integer> ids) {

	 return ClientService.getClient( ids );
	}
	public void updateClientOfDatabase(String newName, String oldName) {

		ClientService.updateName(newName, oldName);
	}
	public void deleteClientFromDatabase(Integer id) {

		ClientService.deleteClient(id);
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

        Client c1,c2,c3;
		c1=new Client("jojo@gmail.com", "Jojo", "jojo");
		c2=  new Client("jaja@gmail.com","jaja","jaja");
		c3=  new Client("jiji@gmail.com","jiji","jiji");
		ArrayList<Client> clientsLists= new ArrayList<>();

		clientsLists.add(c1);
		clientsLists.add(c2);
		clientsLists.add(c3);
		boolean creer = true; // configuration manuelle pour que le code ne se persite pas 2 fois ( à automatiser )

		try {
			// TODO create and persist entity
			if (!creer){

			for (Client c : clientsLists) {

					test.addClientToDatabase(c);

			}
				creer = false;
			}
			List<Integer> ids = new ArrayList<>();
			ids.add(203);
			ids.add(252);
			ids.add(253);
			List<Client> clients_result=test.getClientsFromDatabase(ids);

            int i=0;
			for (Client c : clients_result) {

				System.out.println(clients_result.get(i).getName());
				++i;

			}

			//test.updateClientOfDatabase("francky","Franck");
			//test.deleteClientFromDatabase(153);


		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println(".. done");
	}

}
