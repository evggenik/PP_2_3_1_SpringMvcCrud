package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
//@Component
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
//    @Autowired
    private EntityManager entityManager;


    @Override
    public List<User> listAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
//        List<User> users = entityManager.createQuery("select a from User a").getResultList();
//        return users;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public void updateUser(User user) {

    }
}
