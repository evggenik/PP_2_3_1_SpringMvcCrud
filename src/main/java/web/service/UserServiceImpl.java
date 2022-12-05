package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

//@Component
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
//    @Transactional
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
//    @Transactional
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }

    @Override
    public void deleteUser(int id) {
        userDao.removeUser(id);
    }
}
