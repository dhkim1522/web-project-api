package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService{

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User createUser(UserDTO userDTO) {
        return userRepository.save(userDTO.toEntity());
    }

    @Transactional
    public User updateUser(Long userSeqId, UserDTO userDTO) {
        User user = userRepository.findById(userSeqId).orElseThrow(() ->
        new IllegalArgumentException("해당 회원 정보가 없습니다."));

        user.update(userDTO);

        return user;
    }

    public void deleteBook(Long userSeqId) {
        userRepository.deleteById(userSeqId);
    }
}
