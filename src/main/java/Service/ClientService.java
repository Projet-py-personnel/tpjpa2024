package Service;
import dao.ClientDao;
import domain.Client;

import java.util.List;


public class ClientService {
    static ClientDao dao = new ClientDao();


    // Ajouter un utilisateur
    public static void addClient(Client client) {
        dao.save(client);
    }

    public static void updateName(String newName, String oldName) {
        dao.updateName(newName,oldName);
    }
    public static void deleteClient(List<Integer> ids) {
        dao.delete(ids);
    }
    public static List<Client> getClient(List<Integer> ids) {
       return dao.get(ids);
    }
    public static List<Client> getAllClients() {
        return dao.getAllClients();
    }

}
