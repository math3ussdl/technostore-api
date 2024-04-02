package me.math3ussdl.technostoreapi.features.user;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.math3ussdl.technostoreapi.features.user.dto.UserCreateDto;
import me.math3ussdl.technostoreapi.features.user.dto.UserDto;
import me.math3ussdl.technostoreapi.features.user.internal.User;

@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "active", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updated", ignore = true)
    User userCreateDtoToUser(UserCreateDto userCreateDto);

    @Mapping(target = "password", ignore = true)
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);
    List<UserDto> userListToUserDtoList(List<User> userList);
}
