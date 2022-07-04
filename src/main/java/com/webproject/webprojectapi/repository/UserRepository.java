package com.webproject.webprojectapi.repository;

import com.webproject.webprojectapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
