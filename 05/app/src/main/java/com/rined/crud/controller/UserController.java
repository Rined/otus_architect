package com.rined.crud.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.rined.crud.model.AuthenticatedUser;
import com.rined.crud.model.dto.UserDto;
import com.rined.crud.model.dto.Views;
import com.rined.crud.resolver.AuthUser;
import com.rined.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/user/me")
    @JsonView(Views.GetDto.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@AuthUser AuthenticatedUser user) {
        return service.getUserById(user);
    }

    @PutMapping("/user/me")
    @JsonView(Views.GetDto.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDto putUser(@AuthUser AuthenticatedUser user,
                           @JsonView(Views.General.class) @Validated(Views.General.class)
                           @RequestBody UserDto putUserDto) {
        return service.updateUser(user, putUserDto);
    }

}
