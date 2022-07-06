package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Transactional
    public User createUser(UserDTO userDTO) {

        log.info("userDTO Password ->> " + userDTO.getUserPassword());

        String encodePassword = passwordEncoder.encode(userDTO.getUserPassword());

        log.info("encodePassword ->> " + encodePassword);

        userDTO.setUserPassword(encodePassword);

        return userRepository.save(userDTO.toEntity());
    }

    @Transactional
    public User updateUser(Long userSeqId, UserDTO userDTO) {
        User user = userRepository.findById(userSeqId).orElseThrow(() ->
        new IllegalArgumentException("해당 회원 정보가 없습니다."));

        user.update(userDTO);

        return user;
    }
    @Transactional
    public void deleteUser(Long userSeqId) {
        userRepository.deleteById(userSeqId);
    }

    public User login(UserDTO userDTO) {

        User loginUser = userDTO.toEntity();

        // 로그인 시 가입 회원이 맞는지 DB 조회
        User user = userRepository.findByUserId(loginUser.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 존재하지 않습니다."));

        // 로그인 시 회원 비밀번호 일치 여부 확인
        if(!passwordEncoder.matches(loginUser.getUserPassword(), user.getUserPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }

}
