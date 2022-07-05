/*
package com.webproject.webprojectapi.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@AutoConfigureMockMvc
public class UserMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper om;

    */
/*Map<String, String> map = new HashMap<>();

    @Before
    public void init() {
        map.put("userSeqId", "1");
        map.put("userId", "dhkim1522");
        map.put("userName", "김동현");
        map.put("userPassword", "1111");
        map.put("userEmail", "dhkim1522@naver.com");
    }*//*


    @Test
    @DisplayName("회원 조회 테스트")
    public void getUser() throws Exception {
        Map<String, String> map = new HashMap<>();

        mockMvc.perform(
                        get("/api/v1/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(om.writeValueAsString(map)))
                .andExpect(
                        status()
                                .isOk())
                .andDo(print());

    }

    @Test
    @DisplayName("회원 생성 테스트")
    public void createUser() throws Exception {

        Map<String, String> map = new HashMap<>();

        map.put("userSeqId", "1");
        map.put("userId", "dhkim1522");
        map.put("userName", "김동현");
        map.put("userPassword", "1111");
        map.put("userEmail", "dhkim1522@naver.com");

        log.info("map 조회 " + map.get("userId"));


        mockMvc.perform(
                        post("/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(om.writeValueAsString(map)))
                .andExpect(
                        status()
                                .isOk())
                .andDo(print());

    }

    @Test
    @DisplayName("회원 수정 테스트")
    public void updateUser() throws Exception {
        Map<String, String> map = new HashMap<>();

        mockMvc.perform(
                        put("/user/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(om.writeValueAsString(map)))
                .andExpect(
                        status()
                                .isOk())
                .andDo(print());

    }
}*/
