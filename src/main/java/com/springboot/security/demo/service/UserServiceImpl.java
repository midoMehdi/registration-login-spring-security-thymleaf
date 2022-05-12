package com.springboot.security.demo.service;

import com.springboot.security.demo.controller.dto.UserRegistrationDto;
import com.springboot.security.demo.model.Role;
import com.springboot.security.demo.model.User;
import com.springboot.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstname(),
                userRegistrationDto.getLastname(),
                userRegistrationDto.getEmail(),
                this.passwordEncoder.encode(userRegistrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER")));
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("this email : %s, not exist",username));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
