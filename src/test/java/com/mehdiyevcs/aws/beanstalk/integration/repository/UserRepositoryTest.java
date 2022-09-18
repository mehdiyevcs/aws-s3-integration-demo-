package com.mehdiyevcs.aws.beanstalk.integration.repository;

import com.mehdiyevcs.aws.beanstalk.integration.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save_Should_ReturnSuccess() {
        //given
        var userEntity = new UserEntity(null, "Jalal", "Mehdiyev", "test@Example.com");

        //when
        var response = userRepository.save(userEntity);

        //then
        assertNotNull(response.getId());
    }

    @Test
    void findAll_Should_ReturnEmptyList_When_Empty() {
        //when
        var response = userRepository.findAll();

        //then
        Assertions.assertTrue(response.isEmpty());
    }

    @Test
    void findAll_Should_ReturnSuccess() {
        //given
        var userEntity1 = userRepository.save(new UserEntity(null, "Jalal", "Mehdiyev", "test@Example.com"));
        var userEntity2 = userRepository.save(new UserEntity(null, "Jalal", "Mehdiyev", "test@Example.com"));

        //when
        var userEntityList = userRepository.findAll();

        //then
        assertEquals(2, userEntityList.size());
        assertEquals(List.of(userEntity1, userEntity2), userEntityList);
    }

}
