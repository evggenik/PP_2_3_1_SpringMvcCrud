package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> listAllUsers();
    public void addUser(User user);
    public void removeUser(int id);
    public void updateUser(User user);
}
