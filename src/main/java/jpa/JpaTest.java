package jpa;
import Service.ConcertsService;
import Service.UsersService;
import domain.Roles;
import domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JpaTest {

	private EntityManager manager;


	public void addToDatabase(UsersService usersService) {
		// Ajouter des utilisateurs
		Users user = new Users();
		user.setName("toto");
		user.setEmail("bototo@mail.com");
		user.setPassword("vvvvvvv");
		user.setRole(Roles.ORGANIZER);
		usersService.addUser(user);
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
			UsersService usersService = new UsersService();
			test.addToDatabase(usersService);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

}
