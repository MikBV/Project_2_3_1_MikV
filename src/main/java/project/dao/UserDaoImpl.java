package project.dao;

import org.springframework.stereotype.Repository;
import project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(this.findUserById(id));
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        String hql = "from User";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
