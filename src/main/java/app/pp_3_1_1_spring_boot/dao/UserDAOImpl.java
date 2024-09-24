package app.pp_3_1_1_spring_boot.dao;

import app.pp_3_1_1_spring_boot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            User newUser = entityManager.merge(user);
            user.setId(newUser.getId());
        }
    }

    @Override
    public User getUser(int id) { return entityManager.find(User.class, id); }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

}