package Service;

import dao.OrganisateurDAO;
import domain.Organisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class OrganisateurService {

    private static OrganisateurDAO organisateurDAO;
    private static EntityManager entityManager;

    static {
        entityManager = Persistence.createEntityManagerFactory("your-persistence-unit").createEntityManager();
        organisateurDAO = new OrganisateurDAO(entityManager);
    }

    public static void addOrganisateur(Organisateur organisateur) {
        organisateurDAO.addOrganisateur(organisateur);
    }

    public static Organisateur getOrganisateurById(Long id) {
        return organisateurDAO.getOrganisateurById(id);
    }

    public static List<Organisateur> getOrganisateurs(List<Long> ids) {
        return organisateurDAO.getOrganisateurs(ids);
    }

    public static List<Organisateur> getAllOrganisateurs() {
        return organisateurDAO.getAllOrganisateurs();
    }

    public static void updateOrganisateur(Organisateur organisateur) {
        organisateurDAO.updateOrganisateur(organisateur);
    }

    public static void deleteOrganisateur(List<Long> ids) {
        organisateurDAO.deleteOrganisateur(ids);
    }
}
