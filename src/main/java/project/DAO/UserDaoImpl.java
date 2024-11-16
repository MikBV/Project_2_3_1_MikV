package project.DAO;

import project.model.User;
import project.util.Util;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUsersTable() {
        EntityManager entityManager = Util.getEntityFactory();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery();
        entityManager.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void cleanUsersTable() {

    }
}
