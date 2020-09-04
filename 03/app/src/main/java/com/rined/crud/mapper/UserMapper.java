package com.rined.crud.mapper;


import com.rined.crud.model.User;
import com.rined.crud.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", source = "user.id"),
            @Mapping(target = "username", source = "user.username"),
            @Mapping(target = "firstName", source = "user.firstName"),
            @Mapping(target = "lastName", source = "user.lastName"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "phone", source = "user.phone"),
    })
    UserDto convertUserToGetDto(User user);

    @Mappings({
            @Mapping(target = "username", source = "postUserDto.username"),
            @Mapping(target = "firstName", source = "postUserDto.firstName"),
            @Mapping(target = "lastName", source = "postUserDto.lastName"),
            @Mapping(target = "email", source = "postUserDto.email"),
            @Mapping(target = "phone", source = "postUserDto.phone"),
    })
    User convertPostDtoToUser(UserDto postUserDto);

    @Mappings({
            @Mapping(target = "id", source = "dbUser.id"),
            @Mapping(target = "username", source = "dbUser.username"),
            @Mapping(target = "firstName", source = "putUserDto.firstName"),
            @Mapping(target = "lastName", source = "putUserDto.lastName"),
            @Mapping(target = "email", source = "putUserDto.email"),
            @Mapping(target = "phone", source = "putUserDto.phone"),
    })
    User convertPutDtoToUser(User dbUser, UserDto putUserDto);

}
