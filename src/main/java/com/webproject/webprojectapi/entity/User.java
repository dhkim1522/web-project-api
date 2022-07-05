package com.webproject.webprojectapi.entity;

import com.webproject.webprojectapi.dto.UserDTO;
import lombok.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User {

    /**
     *  회원(User) 엔티티
     *  @Author dhkim1522(김동현)
     */
    @Id
    @Column(name = "USER_SEQ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeqId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    public void update(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.userName = userDTO.getUserName();
        this.userPassword = userDTO.getUserPassword();
        this.userEmail = userDTO.getUserEmail();
    }

    /**
     *  추후 생성되어야 할 필드 목록
     *  가입일시, 생년월일, 성별 등 부수적 정보
     */
}
