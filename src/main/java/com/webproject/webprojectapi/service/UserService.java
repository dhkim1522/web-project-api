package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.dto.UserLoginDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.vo.UserVO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    // 회원 조회
    User getUser(Long userSeqId);
    // 회원아이디 조회
    Map<String, Integer> duplicationUserCheck(String userId);
    // 회원 생성
    User createUser(UserDTO userDTO);
    // 회원 수정
    User updateUser(Long userSeqId, UserDTO userDTO);
    // 회원 삭제
    void deleteUser(Long userSeqId);
    // 로그인
    UserVO login(UserLoginDTO userLoginDTO);
    // 전체 카운트
    Long getCountAll();
}
