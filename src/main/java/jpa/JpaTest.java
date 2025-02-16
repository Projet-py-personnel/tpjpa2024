package jpa;
import Service.AdminService;
import Service.OrganisateurService;
import domain.Administrateur;
import domain.Organisateur;
import org.mindrot.jbcrypt.BCrypt;

public class JpaTest {

	public void addToDatabase(AdminService adminService) {
		// Ajout personne
		Administrateur admin = new Administrateur();
		admin.setName("Pipo");
		admin.setEmail("Popo@mail.com");
		String hashedPassword = BCrypt.hashpw("vvvffevvdffsqbv", BCrypt.gensalt());
		admin.setPassword(hashedPassword);
		adminService.addAdmin(admin);
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
			AdminService adminService = new AdminService();
			test.addToDatabase(adminService);// service appelle dao
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".. done");
	}

}
