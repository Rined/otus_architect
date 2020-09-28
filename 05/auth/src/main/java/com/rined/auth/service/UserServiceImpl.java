package com.rined.auth.service;

import com.rined.auth.exception.AlreadyExistsException;
import com.rined.auth.model.User;
import com.rined.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with login %s not found!", username)));
    }

    @Override
    public void register(User user) {
        String username = user.getUsername();
        if(repository.existsByLogin(username))
            throw new AlreadyExistsException("User with name %s already exists!", username);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
    }
}
