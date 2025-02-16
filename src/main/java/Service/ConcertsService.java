package Service;

import dao.ConcertDao;
import domain.Concert;
public class ConcertsService {

    ConcertDao dao = new ConcertDao();

    public void addConcert(Concert concert){
        dao.save(concert);
    }

}
