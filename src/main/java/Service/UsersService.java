package Service;

import dao.UserDao;
import jakarta.persistence.EntityManager;

public class UsersService {
    private EntityManager manager;
    UserDao dao = new UserDao();


    // Ajouter un utilisateur
    public void addUser(Users user) {
        dao.save(user);
    }

}
