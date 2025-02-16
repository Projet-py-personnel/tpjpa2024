package Service;

import dao.TicketDao;
import domain.Ticket;

public class TicketService {
    TicketDao dao = new TicketDao();

    public void addTicket(Ticket ticket){
        dao.save(ticket);
    }
}
