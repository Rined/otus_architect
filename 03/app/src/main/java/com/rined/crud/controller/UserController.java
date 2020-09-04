package com.rined.crud.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rined.crud.model.dto.UserDto;
import com.rined.crud.model.dto.Views;
import com.rined.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/user/{id}")
    @JsonView(Views.GetDto.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping("/user")
    @JsonView(Views.GetDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto postUser(@JsonView(Views.PostDto.class) @Validated(Views.PostDto.class)
                            @RequestBody UserDto postUserDto) {
        return service.createUser(postUserDto);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    @JsonView(Views.GetDto.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDto putUser(@PathVariable("id") Long id,
                           @JsonView(Views.PutDto.class) @Validated(Views.PutDto.class)
                           @RequestBody UserDto putUserDto) {
        return service.updateUser(id, putUserDto);
    }

}
