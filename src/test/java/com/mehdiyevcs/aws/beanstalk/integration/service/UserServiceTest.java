package com.mehdiyevcs.aws.beanstalk.integration.service;

import com.mehdiyevcs.aws.beanstalk.integration.entity.UserEntity;
import com.mehdiyevcs.aws.beanstalk.integration.model.UserDto;
import com.mehdiyevcs.aws.beanstalk.integration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getUsers_Should_ReturnSuccess() {
        //given
        var expectedUserEntity = new UserEntity(1L, "Jalal", "Mehdiyev", "test@Example.com");
        given(userRepository.findAll()).willReturn(List.of(expectedUserEntity));
        var expectedResponse = List.of(new UserDto(1L, "Jalal", "Mehdiyev", "test@Example.com"));

        //when
        var response = userService.getUsers();

        //then
        assertEquals(expectedResponse, response);
    }

    @Test
    void createUser_Should_ReturnSuccess() {
        //given
        var request = new UserDto(null, "Jalal", "Mehdiyev", "test@Example.com");
        var userEntity = new UserEntity(null, "Jalal", "Mehdiyev", "test@Example.com");
        var expectedUserEntity = new UserEntity(null, "Jalal", "Mehdiyev", "test@Example.com");
        given(userRepository.save(userEntity)).willReturn(expectedUserEntity);
        var expectedResponse = new UserDto(null, "Jalal", "Mehdiyev", "test@Example.com");

        //when
        var response = userService.createUser(request);

        //then
        assertEquals(expectedResponse, response);
    }
}
