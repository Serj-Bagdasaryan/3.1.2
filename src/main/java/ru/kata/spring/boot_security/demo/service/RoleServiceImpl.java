package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository rRepository) {
        this.roleRepository = rRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Integer integer) {
        return roleRepository.getById(integer);
    }
}
