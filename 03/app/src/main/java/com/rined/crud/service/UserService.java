package com.rined.crud.service;

import com.rined.crud.model.dto.UserDto;

public interface UserService {

    UserDto getUserById(Long id);

    UserDto createUser(UserDto postUserDto);

    void deleteUser(Long id);

    UserDto updateUser(Long id, UserDto putUserDto);
}
