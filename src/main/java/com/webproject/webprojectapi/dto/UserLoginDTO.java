package com.webproject.webprojectapi.dto;

import com.webproject.webprojectapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginDTO {

    private String userId;
    private String userPassword;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPassword(userPassword)
                .build();
    }
}
