package Service;

import dao.OrganisateurDao;
import domain.Organisateur;


public class OrganisateurService {

    OrganisateurDao dao = new OrganisateurDao();


    // Ajouter un utilisateur
    public void addUser(Organisateur organisateur) {
        dao.save(organisateur);
    }

    //Lister les utilisateurs


}
