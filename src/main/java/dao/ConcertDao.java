package dao;

import domain.Client;
import domain.Concert;

public class ConcertDao extends AbstractJpaDao<Long , Concert>{

    public ConcertDao(){
        super(Concert.class);

    }
}
