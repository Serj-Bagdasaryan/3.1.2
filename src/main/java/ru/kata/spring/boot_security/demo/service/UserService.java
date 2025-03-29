package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void create(User user);
    void update(Integer id, User user);
    User find(Integer id);
    List<User> findAll();
    void delete(Integer id);

    Optional<User> findByUsername(String username);

}
