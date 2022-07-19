package com.webproject.webprojectapi.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
/**
 *   JWT Token 을 담은 User 객체를 반환하기 위한 VO
 */
public class UserVO {

    private String userSeqId;
    private String userId;
    private String userNickname;
    private String userPassword;
    private String userEmail;

    // JWT Token
    private String token;
}
