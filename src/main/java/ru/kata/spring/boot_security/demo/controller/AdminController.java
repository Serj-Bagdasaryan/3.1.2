package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminController {
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String showUsers(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("allRoles", roleService.findAll());
        return "users";
    }

    @GetMapping("")
    public String showUser(@RequestParam(value = "id") Integer id, ModelMap model) {
        model.addAttribute("allRoles", roleService.findAll());
        model.addAttribute("users", userService.find(id));
        return "oneUser";
    }

    @PatchMapping("/update")
    public String updateUser(@RequestParam Integer id, @ModelAttribute User user) {
        userService.update(id, user);
        return "redirect:/admin/user?id=" + id;
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/admin/user/all";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Integer id) {
        userService.delete(id);
        return "redirect:/admin/user/all";
    }
}
