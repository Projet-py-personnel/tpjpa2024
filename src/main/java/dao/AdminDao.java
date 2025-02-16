package dao;

import domain.Administrateur;

public class AdminDao extends AbstractJpaDao<Long , Administrateur>{

    public AdminDao(){
        super(Administrateur.class);

    }
}
