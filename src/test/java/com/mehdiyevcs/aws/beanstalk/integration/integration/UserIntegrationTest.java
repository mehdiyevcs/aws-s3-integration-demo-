package com.mehdiyevcs.aws.beanstalk.integration.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehdiyevcs.aws.beanstalk.integration.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createUser_Should_ReturnSuccess() throws Exception {
        //given
        var user = new UserDto(null, "DJ", "M", "test@Example.com");
        var expectedUser = new UserDto(1L, "DJ", "M", "test@Example.com");

        //when
        var response = this.mockMvc.perform(post("/users")
                        .content(objectMapper.writeValueAsString(user)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        //then
        assertEquals(objectMapper.writeValueAsString(expectedUser), response.getContentAsString());

    }
}
