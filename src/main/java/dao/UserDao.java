package dao;

import domain.Users;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class UserDao {

    public Users save(Users user) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

        EntityManagerHelper.getEntityManager().persist(user);
        return user;

    }

}
