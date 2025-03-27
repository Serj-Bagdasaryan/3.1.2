package ru.kata.spring.boot_security.demo.controller;


import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //USER
    @GetMapping("/user/info")
    public String showUserInfo(@RequestParam(name = "id") int id, ModelMap model) {
        User user = userService.read(id);
        model.addAttribute("users", user);
        return "userInfo";
    }

    //ADMIN
    @GetMapping("/admin/users")
    public String showUsers(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.readAll());
        model.addAttribute("allRoles", userService.getAllRoles());
        return "users";
    }

    @GetMapping("/admin/user")
    public String showUser(@RequestParam(value = "id") Integer id, ModelMap model) {
        model.addAttribute("allRoles", userService.getAllRoles());
        model.addAttribute("users", userService.read(id));
        return "oneUser";
    }

    @PatchMapping("/admin/user/update")
    public String updateUser(@RequestParam Integer id, @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/admin/user?id=" + id;
    }

    @PostMapping("/admin/user/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/user/delete")
    public String deleteUser(@RequestParam Integer id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
