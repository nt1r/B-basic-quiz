package com.gtb.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gtb.quiz.repository.UserRepository;
import com.gtb.quiz.vo.UserVo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    private final String PREFIX = "/v1/users";
    private final String ADD_USER_URL = PREFIX + "";
    private final String GET_USER_URL = PREFIX + "/%d";

    private final UserVo sampleUserVo = UserVo.builder().name("张三").age(20L).avatar("avatar url").description("班长").build();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        UserRepository.userMap.clear();
        UserRepository.autoIncreaseId.set(0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void loadContext() { }

    @Test
    public void shouldAddOneUser() throws Exception {
        addSampleUser()
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("张三")))
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.avatar", is("avatar url")))
                .andExpect(jsonPath("$.description", is("班长")));
    }

    private ResultActions addSampleUser() throws Exception {
        return mockMvc.perform(post(ADD_USER_URL).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sampleUserVo)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetUserById() throws Exception {
        addSampleUser();

        mockMvc.perform(get(String.format(GET_USER_URL, 1)).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("张三")))
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.avatar", is("avatar url")))
                .andExpect(jsonPath("$.description", is("班长")));
    }

    @Test
    public void shouldReturnNotFoundWhenUserIdInvalid() throws Exception {
        addSampleUser();

        mockMvc.perform(get(String.format(GET_USER_URL, 100)).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", is(404)))
                .andExpect(jsonPath("$.error", is(HttpStatus.NOT_FOUND.getReasonPhrase())))
                .andExpect(jsonPath("$.message", is("User id not found: 100")));
    }
}