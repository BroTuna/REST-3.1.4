package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;


@Controller
@RequestMapping("")
public class MainController { ;
    private UserService userService;
    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("amountOfRoles", userService.getAllRoles());
        return "users";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }
}
