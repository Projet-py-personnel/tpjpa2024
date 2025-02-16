package jpa;
import Service.OrganisateurService;
import domain.Organisateur;
import org.mindrot.jbcrypt.BCrypt;

public class JpaTest {

	public void addToDatabase(OrganisateurService organisateurService) {
		// Ajouter des client
		Organisateur organisateur = new Organisateur();
		organisateur.setName("tata");
		organisateur.setEmail("tavatoto@mail.com");
		organisateur.setGroupe("soft");
		String hashedPassword = BCrypt.hashpw("vvvffevvdffsqbv", BCrypt.gensalt());
		organisateur.setPassword(hashedPassword);
		organisateurService.addUser(organisateur);
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
			OrganisateurService organisateurService = new OrganisateurService();
			test.addToDatabase(organisateurService);// service appelle dao
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".. done");
	}

}
