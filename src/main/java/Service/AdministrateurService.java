package Service;

import dao.AdministrateurDao;
import domain.Administrateur;

import java.util.List;

public class AdministrateurService {
    static AdministrateurDao dao = new AdministrateurDao();

    /**
     * Intervient dans la persistance d'un administrateur en bd
     * @param admin
     * {@link dao.AdministrateurDao#save(Administrateur)}
     */
    public static void addAdministrateur(Administrateur admin) {
        dao.save(admin);
    }

    /**
     * Intervient dans le changement de nom d'un administrateur en bd
     * {@link dao.AdministrateurDao#updateName(String, String)}
     */
    public static void updateName(String newName, String oldName) {
        dao.updateName(newName, oldName);
    }

    /**
     * Intervient dans la suppression d'administrateurs en bd
     * {@link dao.AdministrateurDao#delete(List)}
     */
    public static void deleteAdministrateur(List<Integer> ids) {
        dao.delete(ids);
    }

    /**
     * Intervient dans le chargement d'administrateurs depuis la bd
     * {@link dao.AdministrateurDao#get(List)}
     */
    public static List<Administrateur> getAdministrateurs(List<Integer> ids) {
        return dao.get(ids);
    }

    /**
     * Intervient dans le chargement de tous les administrateurs depuis la bd
     * {@link dao.AdministrateurDao#getAllAdministrateurs()}
     */
    public static List<Administrateur> getAllAdministrateurs() {
        return dao.getAllAdministrateurs();
    }
}
