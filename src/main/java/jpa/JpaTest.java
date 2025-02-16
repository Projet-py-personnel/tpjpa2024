package jpa;
import Service.OrganisateurService;
import domain.Organisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.mindrot.jbcrypt.BCrypt;

public class JpaTest {

	private EntityManager manager;


	public void addToDatabase(OrganisateurService organisateurService) {
		// Ajouter des client
		Organisateur organisateur = new Organisateur();
		organisateur.setName("toto");
		organisateur.setEmail("bototo@mail.com");
		organisateur.setGroupe("Olasoft");
		String hashedPassword = BCrypt.hashpw("vvvvvvv", BCrypt.gensalt());
		organisateur.setPassword(hashedPassword);
		organisateurService.addUser(organisateur);
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
			OrganisateurService organisateurService = new OrganisateurService();
			test.addToDatabase(organisateurService);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
