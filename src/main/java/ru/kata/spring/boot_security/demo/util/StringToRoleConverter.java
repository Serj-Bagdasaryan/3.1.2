package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.UserService;

@Component
public class StringToRoleConverter implements Converter<String, Role> {

    private final UserService userService;

    @Autowired
    public StringToRoleConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Role convert(String source) {
        return userService.readRole(Integer.parseInt(source));
    }
}

