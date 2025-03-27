package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void create(User user) {
        userDAO.create(user);
    }

    public List<Role> getAllRoles() {
        return userDAO.getAllRoles();
    }

    @Transactional
    public void update(Integer id, User user) {
        userDAO.update(id, user);
    }

    @Transactional
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    public User read(Integer id) {
        return userDAO.read(id);
    }

    public List<User> readAll() {
        return userDAO.readAll();
    }

    public Role readRole(Integer role) {
        return userDAO.readRole(role);
    }
}

