package ru.kiasystems.logic.beans.impl;

import ru.kiasystems.logic.beans.interfaces.UserEJBRemote;
import ru.kiasystems.model.entity.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class UserEJB implements UserEJBRemote {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        List<User> users =null;
        if (entityManager!=null) {
            TypedQuery<User> namedQuery = entityManager.createNamedQuery("User.getAllUsers", User.class);
            users = namedQuery.getResultList();
        }
        return users;
    }
    @Override
    public String getName() {
        return this.getClass().getName();
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public User updateUser(User user) {
        user = entityManager.merge(user);
        return user;
    }
    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user)?user:entityManager.merge(user));
    }
}
