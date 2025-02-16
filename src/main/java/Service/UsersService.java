package Service;

import dao.UserDao;
import domain.Roles;
import domain.Users;
import jakarta.persistence.EntityManager;

public class UsersService {
    private EntityManager manager;
    UserDao dao = new UserDao();


    // Ajouter un utilisateur
    public void addUser(Users user) {
        dao.save(user);
    }

    //Lister les utilisateurs


}
