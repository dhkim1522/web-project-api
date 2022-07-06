package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PatchMapping("/user/{userSeqId}")
    public User updateUser(@PathVariable("userSeqId") Long userSeqId, @RequestBody UserDTO userDTO) {
        return userService.updateUser(userSeqId, userDTO);
    }
    @DeleteMapping("/user/{userSeqId}")
    public void DeleteUser(@PathVariable("userSeqId") Long userSeqId) {
        userService.deleteUser(userSeqId);
    }
}
