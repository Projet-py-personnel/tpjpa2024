package Service;
import dao.ClientDao;
import domain.Client;


public class ClientService {
    static ClientDao dao = new ClientDao();


    // Ajouter un utilisateur
    public static void addClient(Client client) {
        dao.save(client);
    }

}
