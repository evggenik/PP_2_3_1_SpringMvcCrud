package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public UserServiceImpl() {
        this.userDao = userDao;
    }

    @Override
//    @Transactional
    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }
}
