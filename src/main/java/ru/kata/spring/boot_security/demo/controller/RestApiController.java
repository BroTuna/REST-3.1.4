package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class RestApiController {

    private UserService userService;

    public RestApiController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
         return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

/*
    @GetMapping("/admin/{id}")
    public ResponseEntity<User> showUser(@PathVariable("id") int id) {
        User userById = userService.getUser(id);
        return userById != null ? new ResponseEntity<>(userById, HttpStatus.OK)
                                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
*/


    @PostMapping("/new")
    public List<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return userService.getAllUsers();
    }

    @PutMapping("/edit")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
