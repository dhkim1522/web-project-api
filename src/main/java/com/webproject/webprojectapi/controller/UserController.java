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
import java.util.Map;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    // TODO: 리턴 타입을 Response 타입으로 바꿔 Response Code를 반환하여 명확하게 예외처리를 할 수 있게 구현 해야함
    // TODO: API 요청 시 마다 JWT Token 인가 처리 구현 해야함 (User)

    private final UserServiceImpl userServiceImpl;

    // 회원 로그인
    @PostMapping("/login")
    public UserVO login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info(" jwt access token : " + userServiceImpl.login(userLoginDTO).toString());
        return userServiceImpl.login(userLoginDTO);
    }

    // 회원 조회
    @GetMapping("/{userSeqId}")
    public User getUser(@PathVariable("userSeqId") Long userSeqId) {
        return userServiceImpl.getUser(userSeqId);
    }
    @PostMapping("/signup")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userServiceImpl.createUser(userDTO);
    }

    // 회원 수정
    @PatchMapping("/{userSeqId}")
    public User updateUser(@PathVariable("userSeqId") Long userSeqId, @RequestBody UserDTO userDTO) {
        return userServiceImpl.updateUser(userSeqId, userDTO);
    }

    // 회원 삭제
    @DeleteMapping("/{userSeqId}")
    public void DeleteUser(@PathVariable("userSeqId") Long userSeqId) {
        userServiceImpl.deleteUser(userSeqId);
    }

    // 회원 ID 중복 체크
    @GetMapping("/duplication/{userId}")
    public Map<String, Integer> duplicationUserCheck(@PathVariable("userId") String userId) {
        return userServiceImpl.duplicationUserCheck(userId);
    }

    // 회원 수 조회
    @GetMapping("/count")
    public Long getCountAll() {
        return userServiceImpl.getCountAll();
    }
}
