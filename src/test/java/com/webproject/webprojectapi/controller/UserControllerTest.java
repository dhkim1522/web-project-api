package com.webproject.webprojectapi.controller;

import com.webproject.webprojectapi.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("회원 조회 Test")
    void getUser() throws Exception {

        Map<String, String> map = new HashMap<>();

        map.put("userId", "dhkim1522");
        map.put("userName", "김동현");
        map.put("userEmail", "dhkim1522@naver.com");
        map.put("userPassword", "1022");

        mockMvc.perform()

    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }
}