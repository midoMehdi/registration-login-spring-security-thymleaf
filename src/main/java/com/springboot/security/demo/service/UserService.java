package com.springboot.security.demo.service;

import com.springboot.security.demo.controller.dto.UserRegistrationDto;
import com.springboot.security.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);
}
