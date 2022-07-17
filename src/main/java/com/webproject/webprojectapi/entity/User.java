package com.webproject.webprojectapi.entity;

import com.webproject.webprojectapi.dto.UserDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User implements UserDetails {

    /**
     *  회원(User) 엔티티
     *  @Author dhkim1522(김동현)
     */
    @Id
    @Column(name = "USER_SEQ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeqId;

    @Column(name = "USER_ID", length = 20)
    private String userId;

    @Column(name = "USER_EMAIL", length = 20)
    private String userEmail;

    // SpringSecurity의 UserDetails 구현체로 getUsername()
    // 메서드를 반드시 구현해야하기 때문에 필드 명이 중복된다. 따라서 userNickname으로 대체한다.
    @Column(name = "USER_NICKNAME", length = 10)
    private String userNickname;

    @Column(name = "USER_PASSWORD")
    private String userPassword;


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public void update(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.userNickname = userDTO.getUserNickname();
        this.userPassword = userDTO.getUserPassword();
        this.userEmail = userDTO.getUserEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.userId;
    }
    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
