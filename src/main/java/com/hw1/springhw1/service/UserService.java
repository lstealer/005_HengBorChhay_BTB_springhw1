package com.hw1.springhw1.service;

import com.hw1.springhw1.repository.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto insert(UserDto userDto);

}
