package com.rined.auth.controller;

import com.rined.auth.model.User;
import com.rined.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping(value = "/registration")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void registration(@Valid @RequestBody User user) {
        service.register(user);
    }

    @GetMapping(value = "/auth")
    @ResponseStatus(code = HttpStatus.OK)
    public void auth(@AuthenticationPrincipal User user, HttpServletResponse response){
        response.addHeader("X-UserId", String.valueOf(user.getId()));
        response.addHeader("X-Username", user.getLogin());
    }

    @GetMapping(value = "/signin")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Map<String, String>> signIn(){
        return ResponseEntity.ok(Collections.singletonMap("message", "Please go to /login and provide Login/Password"));
    }
}
