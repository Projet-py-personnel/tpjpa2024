package Service;

import dao.AdminDao;
import domain.Administrateur;

public class AdminService {
    AdminDao dao = new AdminDao();

    public void addAdmin(Administrateur admin){
        dao.save(admin);
    }
}
