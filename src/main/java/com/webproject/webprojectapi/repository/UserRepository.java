package com.webproject.webprojectapi.repository;

import com.webproject.webprojectapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserSeqId(Long userSeqId);
    Optional<User> findByUserId(String userId);
    Long countBy();
}
