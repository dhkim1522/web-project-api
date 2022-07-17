package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.dto.UserLoginDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.vo.UserVO;

import java.util.List;

public interface UserService {

    // 회원 조회
    List<User> getUser();

    // 회원 생성
    User createUser(UserDTO userDTO);

    // 회원 수정
    User updateUser(Long userSeqId, UserDTO userDTO);

    // 회원 삭제
    void deleteUser(Long userSeqId);

    // 로그인
    UserVO login(UserLoginDTO userLoginDTO);
}
