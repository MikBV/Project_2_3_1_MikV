package project.service;

import project.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUserById(long id);
    void removeUser(User user);
    List<User> getAllUsers();
    void updateUser(User user, boolean checkUpdate);
    User findUserById(long id);
}
