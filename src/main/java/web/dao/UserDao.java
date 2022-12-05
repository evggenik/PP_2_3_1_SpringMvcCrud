package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listAllUsers();
//    List<User> getAllUser();
    public void addUser(User user);
    public User findById(long id);
    public void removeUser(int id);
    public void updateUser(int id, User user);
}
