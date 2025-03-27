package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);
    void update(Integer id, User user);
    void delete(Integer id);
    User read(Integer id);
    List<User> readAll();

    List<Role> getAllRoles();
    Role readRole(Integer role);
}
