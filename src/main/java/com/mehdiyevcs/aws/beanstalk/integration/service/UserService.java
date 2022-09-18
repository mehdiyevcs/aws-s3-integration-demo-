package com.mehdiyevcs.aws.beanstalk.integration.service;

import com.mehdiyevcs.aws.beanstalk.integration.mapper.UserMapper;
import com.mehdiyevcs.aws.beanstalk.integration.model.UserDto;
import com.mehdiyevcs.aws.beanstalk.integration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getUsers() {
        return UserMapper.INSTANCE.toDtoList(userRepository.findAll());
    }

    public UserDto createUser(UserDto userDto) {
        var userEntity = userRepository.save(UserMapper.INSTANCE.toEntity(userDto));
        return UserMapper.INSTANCE.toDto(userEntity);
    }
}
