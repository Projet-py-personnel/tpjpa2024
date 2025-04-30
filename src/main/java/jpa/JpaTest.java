package jpa;
import Service.ClientService;
import domain.Client;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	public JpaTest() {}

	/**
	 * Intervient dans la persistance d'un client en bd
	 * @param client
	 * {@link Service.ClientService#addClient(Client)}
	 */
	public void addClientToDatabase(Client client) {
		ClientService.addClient(client);
	}

	/**
	 * Intervient dans le chargement de clients depuis la bd
	 * {@link Service.ClientService#getClient(List)}
	 */
	public List<Client> getClientsFromDatabase(List<Integer> ids) {
		return ClientService.getClient( ids );
	}

	/**
	 * Intervient dans le chargement de tous les clients depuis la bd
	 * {@link ClientService#getAllClients()}
	 */
	public List<Client> getAllClients() {
		return ClientService.getAllClients();
	}

	/**
	 * Intervient dans le changement de nom d'un client en bd
	 * {@link Service.ClientService#updateName(String, String)}
	 */
	public void updateClientOfDatabase(String newName, String oldName) {
		ClientService.updateName(newName, oldName);
	}

	/**
	 * Intervient dans la suppression de clients en bd
	 * {@link Service.ClientService#deleteClient(List)}
	 */
	public void deleteClientFromDatabase(List<Integer> ids) {
		ClientService.deleteClient(ids);
	}

	public static void main(String[] args) {

		JpaTest test = new JpaTest();
		Client c1,c2,c3;
		c1=new Client("jijo@gmail.com", "Jojo", "jojo");
		c2=  new Client("jaja@gmail.com","jaja","jaja");
		c3=  new Client("jiji@gmail.com","jiji","jiji");
		ArrayList<Client> clientsLists= new ArrayList<>();

		clientsLists.add(c1);
		clientsLists.add(c2);
		clientsLists.add(c3);
		boolean creer = true; // configuration manuelle pour que les clients ne se persite pas 2 fois (à automatiser plutard)

		try {
			/// Persistance d'une liste de clients
			if (!creer){
				for (Client c : clientsLists) {
					test.addClientToDatabase(c);
				}
			}

			/// Extraction d'une liste de clients de la bd
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

			///Extraction de tous les clients de la bd
            List<Client>all_clients=test.getAllClients();
			int j=0;
			for (Client c : all_clients) {
				System.out.println(all_clients.get(j).getName());
				++j;

			}

			/// Suppression d'une liste de clients de la bd
			List<Integer> ids_to_delete = new ArrayList<>();
			ids_to_delete.add(103);
			test.deleteClientFromDatabase(ids_to_delete);

			/// Mise à jour du nom d'un client de la bd
			test.updateClientOfDatabase("Aline","Franck");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".. done");
	}

}
