package ru.kata.spring.boot_security.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    
    public void create(User user) {
        entityManager.persist(user);
    }

    public void update(Integer id, User user) {
        user.setId(id);
        entityManager.merge(user);
    }
    
    public void delete(Integer id) {
        entityManager.remove(read(id));
    }

    public User read(Integer id) {
        return entityManager.find(User.class, id);
    }

    public List<User> readAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    public Role readRole(Integer role) {
        return entityManager.find(Role.class, role);
    }
}
