package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServices userService;
    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.insertUser(user);
    }
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserEntity userData) {

        Optional<UserEntity> existingUser = userService.getOneUser(id);

        if (existingUser.isPresent()) {
            UserEntity user = existingUser.get();

            user.setName(userData.getName());
            user.setEmail(userData.getEmail());
            user.setPassword(userData.getPassword());
            user.setRole(userData.getRole());

            userService.insertUser(user);
            return "User Updated Successfully";
        }

        return "User Not Found";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        Optional<UserEntity> user = userService.getOneUser(id);

        if (user.isPresent()) {
            userService.deleteUser(id);
            return "User Deleted Successfully";
        }

        return "User Not Found";
    }
}