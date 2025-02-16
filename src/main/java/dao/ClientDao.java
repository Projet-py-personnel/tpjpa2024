package dao;

import domain.Client;

public class ClientDao extends AbstractJpaDao<Long , Client> {

    public ClientDao(){
        super(Client.class);
    }

}
