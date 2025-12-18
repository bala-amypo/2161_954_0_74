StudentController.java

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }
    @PostMapping
    public UserEntity postUser(@RequestBody UserEntity st) {
        return userService.insertUser(st);
    }
    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAllUser();
    }
    @GetMapping("/{id}")
    public Optional<UserEntity> getById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserEntity st) {
        Optional<UserEntity> userOpt = userService.getOneUser(id);

        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            user.setName(st.getName());
            user.setEmail(st.getEmail());
            user.setCgpa(st.getCgpa());
            user.setDob(st.getDob());

            userService.insertUser(user);
            return "Updated Successfully";
        }
        return "Student Not Found";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getOneUser(id);

        if (user.isPresent()) {
            userService.deleteUser(id);
            return "Deleted Successfully";
        }
        return "Student Not Found";
    }
}