package com.rined.crud.service;

import com.rined.crud.mapper.UserMapper;
import com.rined.crud.model.AuthenticatedUser;
import com.rined.crud.model.User;
import com.rined.crud.model.dto.UserDto;
import com.rined.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto getUserById(AuthenticatedUser user) {
        return repository.findById(user.getUserId())
                .map(mapper::convertUserToGetDto)
                .orElseGet(() -> mapper.convertAuthenticatedUserToDto(user));
    }

    @Override
    public UserDto updateUser(AuthenticatedUser user, UserDto putUserDto) {
        User usr = repository.findById(user.getUserId())
                .map(dbUser -> mapper.convertDtoAndUserToUser(dbUser, putUserDto))
                .orElseGet(() -> mapper.convertDtoAndAuthenticatedUserToUser(user, putUserDto));
        User savedUser = repository.save(usr);
        return mapper.convertUserToGetDto(savedUser);
    }
}
