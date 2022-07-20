package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.dto.UserLoginDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.jwt.JwtTokenProvider;
import com.webproject.webprojectapi.repository.UserRepository;
import com.webproject.webprojectapi.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

// TODO: User 서비스단 예외처리 로직 구현해야 함
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public User getUser(Long userSeqId) {

        User user = userRepository.findByUserSeqId(userSeqId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 존재하지 않습니다."));

        return user;
    }

    @Override
    public Map<String, Integer> duplicationUserCheck(String userId) {

        Map map = new HashMap();

        Boolean DuplicationCheck = userRepository.findByUserId(userId).isPresent();

        if(DuplicationCheck) {
            map.put("duplication", 1); // 존재하면 1
        } else {
            map.put("duplication", 0); // 존재하지 않으면 0
        }

        return map;
    }


    @Override
    @Transactional
    public User createUser(UserDTO userDTO) {
        String encodePassword = passwordEncoder.encode(userDTO.getUserPassword());

        User user = User.builder()
                .userId(userDTO.getUserId())
                .userPassword(encodePassword)
                .userNickname(userDTO.getUserNickname())
                .userEmail(userDTO.getUserEmail())
                .roles(Collections.singletonList("ROLE_USER"))
                    .build();

        return userRepository.save(user);
    }
    @Override
    @Transactional
    public User updateUser(Long userSeqId, UserDTO userDTO) {
        User user = userRepository.findById(userSeqId).orElseThrow(() ->
        new IllegalArgumentException("해당 회원 정보가 없습니다."));

        user.update(userDTO);

        return user;
    }
    @Override
    @Transactional
    public void deleteUser(Long userSeqId) {
        userRepository.deleteById(userSeqId);
    }

    @Override
    public UserVO login(UserLoginDTO userLoginDTO) {
        User loginUser = userLoginDTO.toEntity();

        // 로그인 시 가입 회원이 맞는지 DB 조회
        User user = userRepository.findByUserId(loginUser.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 존재하지 않습니다."));

        // 로그인 시 회원 비밀번호 일치 여부 확인
        if(!passwordEncoder.matches(loginUser.getUserPassword(), user.getUserPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        log.info("로그인 비밀번호 일치");

        // JWT Token 생성 - getUsername 이지만 실제 return은 userId를 가져온다.
        String token = jwtTokenProvider.createToken(user.getUsername(),user.getRoles());

        return UserVO.builder()
                .userSeqId(String.valueOf(user.getUserSeqId()))
                .userId(user.getUserId())
                .userPassword(user.getUserPassword())
                .userNickname(user.getUserNickname())
                .userEmail(user.getUserEmail())
                .token(token)
                .build();
    }

    @Override
    public Long getCountAll() {
        return userRepository.countBy();
    }
}
