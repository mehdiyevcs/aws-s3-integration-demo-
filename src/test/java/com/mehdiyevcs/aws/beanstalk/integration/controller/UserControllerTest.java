package com.mehdiyevcs.aws.beanstalk.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehdiyevcs.aws.beanstalk.integration.model.UserDto;
import com.mehdiyevcs.aws.beanstalk.integration.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUser() throws Exception {
        //given
        var user = new UserDto(1L, "Jalal", "Mehdiyev", "test@example.com");
        given(userService.createUser(user)).willReturn(user);

        //when
        var response = this.mockMvc.perform(post("/users")
                        .content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        //then
        assertEquals(objectMapper.writeValueAsString(user), response.getContentAsString());
    }

    @Test
    void getUsers() throws Exception {
        //given
        var users = List.of(new UserDto(1L, "Jalal", "Mehdiyev", "test@example.com"));
        given(userService.getUsers()).willReturn(users);

        //when
        var response = this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        //then
        assertEquals(objectMapper.writeValueAsString(users), response.getContentAsString());
    }
}
