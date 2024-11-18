package project.DAO;


import project.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(String name, String lastName, byte age);
    void removeUserById(long id);
    List<User> getAllUsers();
    void cleanUsersTable();
    void updateUser(User user);
}
