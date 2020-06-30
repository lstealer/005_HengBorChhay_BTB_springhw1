package com.hw1.springhw1.service.impl;


import com.hw1.springhw1.repository.UserRepository;
import com.hw1.springhw1.repository.dto.RoleDto;
import com.hw1.springhw1.repository.dto.UserDto;
import com.hw1.springhw1.restcontroller.response.Messages;
import com.hw1.springhw1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(userRepository.selectUserByUsername(username));
        return userRepository.selectUserByUsername(username);
    }

    @Override
    public UserDto insert(UserDto userDto) {
        try {
            userRepository.insert(userDto);
            int id = userRepository.selectIdById(userDto.getId());
            userDto.setId(id);
            for (RoleDto role : userDto.getRoles()) {
                userRepository.createUserRoles(userDto, role);
            }  System.out.println(userDto.getId());
            return userDto;

//            return null;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    Messages.Error.INSERT_FAILURE.getMessage()
            );
        }
    }

}
