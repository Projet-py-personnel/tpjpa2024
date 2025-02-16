package dao;

import domain.Client;
import domain.Ticket;

public class TicketDao extends AbstractJpaDao<Long , Ticket>{
    public TicketDao(){
        super(Ticket.class);
    }

}
