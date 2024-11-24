package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void removeUserById(long id);
    List<User> getAllUsers();
    void updateUser(User user);
    User findUserById(long id);
}
