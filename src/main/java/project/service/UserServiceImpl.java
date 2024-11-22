package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;

import java.util.List;
import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
        System.out.println("UserServiceImpl initialized.");
        System.out.println("UserDao is: " + userDao);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Transactional
    @Override
    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    @Transactional (readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }
}
