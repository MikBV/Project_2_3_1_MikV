package project.DAO;

import project.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void removeUserById(long id);
    List<User> getAllUsers();
    void updateUser(User user);
}
