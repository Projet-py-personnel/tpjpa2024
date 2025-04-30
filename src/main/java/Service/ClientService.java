package Service;
import dao.ClientDao;
import domain.Client;

import java.util.List;


public class ClientService {
    static ClientDao dao = new ClientDao();


    /**
     * Intervient dans la persistance d'un client en bd
     * @param client
     * {@link dao.ClientDao#save(Client)}
     */
    public static void addClient(Client client) {
        dao.save(client);
    }

    /**
     * Intervient dans le changement de nom d'un client en bd
     * {@link dao.ClientDao#updateName(String, String)}
     */
    public static void updateName(String newName, String oldName) {
        dao.updateName(newName,oldName);
    }

    /**
     * Intervient dans la suppression de clients en bd
     * {@link dao.ClientDao#delete(List)}
     */
    public static void deleteClient(List<Integer> ids) {
        dao.delete(ids);
    }

    /**
     * Intervient dans le chargement de clients depuis la bd
     * {@link dao.ClientDao#get(List)}
     */
    public static List<Client> getClient(List<Integer> ids) {
       return dao.get(ids);
    }
    /**
     * Intervient dans le chargement de tous les clients depuis la bd
     * {@link ClientDao#getAllClients()}
     */
    public static List<Client> getAllClients() {
        return dao.getAllClients();
    }

}
