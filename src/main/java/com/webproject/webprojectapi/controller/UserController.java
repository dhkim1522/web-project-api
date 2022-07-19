package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.dto.UserLoginDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.queryInterface.AvgAetDay;
import com.webproject.webprojectapi.service.UserServiceImpl;
import com.webproject.webprojectapi.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    // token 값 반환을 위해서 굳이 User 정보까지 같이 담은 UserVO를 리턴타입으로
    // 구현해야 하는지 생각해 볼 필요 O
    @PostMapping("/login")
    public UserVO login(@RequestBody UserLoginDTO userLoginDTO) {

        log.info("login token 발급 " + userServiceImpl.login(userLoginDTO).toString());

        return userServiceImpl.login(userLoginDTO);
    }

    @GetMapping("/user/{userSeqId}")
    public User getUser(@PathVariable("userSeqId") Long userSeqId) {
        return userServiceImpl.getUser(userSeqId);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userServiceImpl.createUser(userDTO);
    }

    @PatchMapping("/user/{userSeqId}")
    public User updateUser(@PathVariable("userSeqId") Long userSeqId, @RequestBody UserDTO userDTO) {
        return userServiceImpl.updateUser(userSeqId, userDTO);
    }
    @DeleteMapping("/user/{userSeqId}")
    public void DeleteUser(@PathVariable("userSeqId") Long userSeqId) {
        userServiceImpl.deleteUser(userSeqId);
    }

    @GetMapping("/user/count")
    public Long getCountAll() {
        return userServiceImpl.getCountAll();
    }
}
