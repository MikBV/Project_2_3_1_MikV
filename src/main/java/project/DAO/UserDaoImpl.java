package project.DAO;

import org.springframework.transaction.annotation.Transactional;
import project.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    @Transactional
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

    @Override
    public void updateUser(User user) {

    }
}
