package com.rined.crud.mapper;


import com.rined.crud.model.AuthenticatedUser;
import com.rined.crud.model.User;
import com.rined.crud.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
@SuppressWarnings("UnmappedTargetProperties")
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
            @Mapping(target = "id", source = "authenticatedUser.userId"),
            @Mapping(target = "username", source = "authenticatedUser.username"),
    })
    UserDto convertAuthenticatedUserToDto(AuthenticatedUser authenticatedUser);

    @Mappings({
            @Mapping(target = "id", source = "dbUser.id"),
            @Mapping(target = "username", source = "dbUser.username"),
            @Mapping(target = "firstName", source = "putUserDto.firstName"),
            @Mapping(target = "lastName", source = "putUserDto.lastName"),
            @Mapping(target = "email", source = "putUserDto.email"),
            @Mapping(target = "phone", source = "putUserDto.phone"),
    })
    User convertDtoAndUserToUser(User dbUser, UserDto putUserDto);

    @Mappings({
            @Mapping(target = "id", source = "authenticatedUser.userId"),
            @Mapping(target = "username", source = "authenticatedUser.username"),
            @Mapping(target = "firstName", source = "putUserDto.firstName"),
            @Mapping(target = "lastName", source = "putUserDto.lastName"),
            @Mapping(target = "email", source = "putUserDto.email"),
            @Mapping(target = "phone", source = "putUserDto.phone"),
    })
    User convertDtoAndAuthenticatedUserToUser(AuthenticatedUser authenticatedUser, UserDto putUserDto);

}
