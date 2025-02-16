package jpa;
import Service.AdminService;
import Service.ClientService;
import Service.ConcertsService;
import Service.OrganisateurService;
import domain.Administrateur;
import domain.Client;
import domain.Concert;
import domain.Organisateur;
import org.mindrot.jbcrypt.BCrypt;

public class JpaTest {

	public void addPersonToDatabase(ClientService clientService) {
		// Ajout personne
		Client client = new Client();
		client.setName("Pola titi");
		client.setEmail("Popotiti@mail.com");
		String hashedPassword = BCrypt.hashpw("vvvffevvdffsqbv", BCrypt.gensalt());
		client.setPassword(hashedPassword);
		clientService.addClient(client);
	}

	public void addConcertToDb(ConcertsService concertsService){

		// Ajout Concerts
		Concert concert = new Concert();
		concert.setTitle("Concert");
		concert.setDescription("Concert tres exitant");
		concert.setLocation("Stade Rennes");
		concert.getArtiste("Star");
		concertsService.addConcert(concert);
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
			ClientService clientService = new ClientService();
			test.addPersonToDatabase(clientService);
			// TODO create and persist entity
			ConcertsService concertsService = new ConcertsService();
			test.addConcertToDb(concertsService);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".. done");
	}

}
