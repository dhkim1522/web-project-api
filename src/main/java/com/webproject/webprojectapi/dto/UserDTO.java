package com.webproject.webprojectapi.dto;

import com.webproject.webprojectapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long userSeqId;
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userPassword(userPassword)
                .userEmail(userEmail)
                .build();
    }
}
