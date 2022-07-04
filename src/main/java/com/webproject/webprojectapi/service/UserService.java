package com.webproject.webprojectapi.service;

import com.webproject.webprojectapi.dto.UserDTO;
import com.webproject.webprojectapi.entity.User;
import com.webproject.webprojectapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("해당 회원 정보가 없습니다."));

        user.update(userDTO);

        return user;
    }

}
