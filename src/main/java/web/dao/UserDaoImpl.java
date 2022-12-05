package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> listAllUsers() {
//        return entityManager.createQuery("select u from User u", User.class).getResultList();
        List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
        return users;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User findById(long id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeUser(int id) {
        User user = findById(id);
        entityManager.remove(user);
//    TypedQuery<User> query = entityManager.createQuery(
//            "delete u from User u where u.id := id", User.class);
//    query.setParameter("id", id);
//    query.executeUpdate();
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User userToBeUpdated = findById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setMail(updatedUser.getMail());
        entityManager.merge(userToBeUpdated);
    }

}
