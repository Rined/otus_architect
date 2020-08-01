package com.rined.crud.service;

import com.rined.crud.exception.NotFoundException;
import com.rined.crud.mapper.UserMapper;
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
    public UserDto getUserById(Long id) {
        return repository.findById(id)
                .map(mapper::convertUserToGetDto)
                .orElseThrow(() -> new NotFoundException("User with id \"%d\" not found", id));
    }

    @Override
    public UserDto createUser(UserDto postUserDto) {
        return mapper.convertUserToGetDto(repository.save(mapper.convertPostDtoToUser(postUserDto)));
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, UserDto putUserDto) {
        return repository.findById(id)
                .map(dbUser -> mapper.convertPutDtoToUser(dbUser, putUserDto))
                .map(repository::save)
                .map(mapper::convertUserToGetDto)
                .orElseThrow(() -> new NotFoundException("User with id \"%d\" not found", id));
    }
}
