package com.mehdiyevcs.aws.beanstalk.integration.mapper;

import com.mehdiyevcs.aws.beanstalk.integration.entity.UserEntity;
import com.mehdiyevcs.aws.beanstalk.integration.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(UserEntity userEntity);

    List<UserDto> toDtoList(List<UserEntity> userEntity);

    UserEntity toEntity(UserDto userDto);
}
