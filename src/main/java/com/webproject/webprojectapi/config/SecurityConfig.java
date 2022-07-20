package com.webproject.webprojectapi.config;

import com.webproject.webprojectapi.jwt.JwtAuthenticationFilter;
import com.webproject.webprojectapi.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { // Spring Security 5.7.X 부터 지원 중단

    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 인증 방식 사용을 위해 세션 비활성화
                .and()
                .formLogin().disable()
                .headers().frameOptions().disable()
                .and()
                .antMatcher("/api/**")
                .authorizeRequests()
                    .antMatchers("/api/user/login", "/api/user/signup").permitAll() // 권한 없을 시 login, signup 페이지만 접근 가능
                    .antMatchers("/api/**").hasRole("USER") // 권한에 따른 접근 페이지 설정 가능
//                .antMatchers("/api/**").permitAll() // 권한 없어도 모든 페이지 허용
                .anyRequest().authenticated() // 그외 나머지는 권한 있을 때만 접근 가능ㅇ
                /*.and()
                    // 로그인 설정
                    .formLogin()
                        .loginPage("/api/login") // 로그인 페이지 url
                        .defaultSuccessUrl("/api/dashboard") // 로그인 성공 시 연결 url
                .and()
                    // 로그아웃 설정
                    .logout()
                        .logoutSuccessUrl("/api/login") // 로그아웃 시 연결 url
                        .invalidateHttpSession(true) // 로그아웃 시 저장 세션 삭제*/
                .and()
                // Filter를 통해 헤더(X-AUTH-TOKEN)에 담긴 토큰 값 유효성을 검증한다.
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
    }

    /**
     *   Spring Security 5.7.X 부터 WebSecurityConfigurerAdapter 클래스
     *   지원이 중단됨에 따라 아래와 같이 SecurityFilterChain 클래스로 configure를 구현해야 함.
     */
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //.httpBasic().disable()
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 인증 방식 사용을 위해 세션 비활성화
                .and()
                .formLogin().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
//                    .antMatchers("/api/login", "/api/signup").permitAll() // 권한 없을 시 login, signup 페이지만 접근 가능
//                    .antMatchers("/api/**").hasRole("USER") // 권한에 따른 접근 페이지 설정 가능
                .antMatchers("/api/**").permitAll() // 권한 없어도 모든 페이지 허용
                .anyRequest().authenticated() // 그외 나머지는 권한 있을 때만 접근 가능
                *//*.and()
                    // 로그인 설정
                    .formLogin()
                        .loginPage("/api/login") // 로그인 페이지 url
                        .defaultSuccessUrl("/api/dashboard") // 로그인 성공 시 연결 url
                .and()
                    // 로그아웃 설정
                    .logout()
                        .logoutSuccessUrl("/api/login") // 로그아웃 시 연결 url
                        .invalidateHttpSession(true) // 로그아웃 시 저장 세션 삭제*//*
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }*/
}
