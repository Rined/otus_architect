package com.rined.crud.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AuthenticatedUser {
    private final Long userId;
    private final String username;
}
