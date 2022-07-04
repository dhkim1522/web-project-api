package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
}
