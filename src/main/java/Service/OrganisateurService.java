package Service;

import dao.OrganisateurDao;
import domain.Organisateur;
import jakarta.persistence.EntityManager;

public class OrganisateurService {
    private EntityManager manager;
    OrganisateurDao dao = new OrganisateurDao();


    // Ajouter un utilisateur
    public void addUser(Organisateur organisateur) {
        dao.save(organisateur);
    }

    //Lister les utilisateurs


}
