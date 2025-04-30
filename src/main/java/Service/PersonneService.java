package Service;

import dao.PersonneDAO;
import domain.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonneService {

    private static PersonneDAO personneDAO;
    private static EntityManager entityManager;

    static {
        entityManager = Persistence.createEntityManagerFactory("your-persistence-unit").createEntityManager();
        personneDAO = new PersonneDAO(entityManager);
    }

    public static void addPersonne(Personne personne) {
        personneDAO.addPersonne(personne);
    }

    public static Personne getPersonneById(Long id) {
        return personneDAO.getPersonneById(id);
    }

    public static List<Personne> getPersonnes(List<Long> ids) {
        return personneDAO.getPersonnes(ids);
    }

    public static List<Personne> getAllPersonnes() {
        return personneDAO.getAllPersonnes();
    }

    public static void updatePersonne(Personne personne) {
        personneDAO.updatePersonne(personne);
    }

    public static void deletePersonne(List<Long> ids) {
        personneDAO.deletePersonne(ids);
    }
}
