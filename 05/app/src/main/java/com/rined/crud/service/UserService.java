package com.rined.crud.service;

import com.rined.crud.model.AuthenticatedUser;
import com.rined.crud.model.dto.UserDto;

public interface UserService {

    UserDto getUserById(AuthenticatedUser user);

    UserDto updateUser(AuthenticatedUser user, UserDto putUserDto);

}
