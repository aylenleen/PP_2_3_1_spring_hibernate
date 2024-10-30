package org.example.dao;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, (long) id);
    }
}
