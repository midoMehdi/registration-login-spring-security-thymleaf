package com.springboot.security.demo.service;

import com.springboot.security.demo.controller.dto.UserRegistrationDto;
import com.springboot.security.demo.model.User;

public interface UserService {

    User save(UserRegistrationDto userRegistrationDto);
}
