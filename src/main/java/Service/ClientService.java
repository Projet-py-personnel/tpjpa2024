package Service;

import dao.ClientDao;
import domain.Client;

public class ClientService {
    ClientDao dao = new ClientDao();

    public void addClient(Client client){
        dao.save(client);
    }

}
