package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listAllUsers();
    void addUser(User user);
    User findById(long id);
    void updateUser(int id, User updateUser);
    void deleteUser(int id);

}
