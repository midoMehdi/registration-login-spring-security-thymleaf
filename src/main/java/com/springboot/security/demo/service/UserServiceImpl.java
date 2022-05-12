package com.springboot.security.demo.service;

import com.springboot.security.demo.controller.dto.UserRegistrationDto;
import com.springboot.security.demo.model.Role;
import com.springboot.security.demo.model.User;
import com.springboot.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstname(),
                userRegistrationDto.getLastname(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(),
                Arrays.asList(new Role("ROLE_USER")));
        return this.userRepository.save(user);
    }
}
