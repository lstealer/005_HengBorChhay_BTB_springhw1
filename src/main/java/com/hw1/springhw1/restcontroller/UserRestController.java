package com.hw1.springhw1.restcontroller;


import com.hw1.springhw1.repository.dto.UserDto;
import com.hw1.springhw1.restcontroller.request.UserRequestModel;
import com.hw1.springhw1.restcontroller.response.BaseApiResponse;
import com.hw1.springhw1.restcontroller.response.Messages;
import com.hw1.springhw1.restcontroller.response.UserRest;
import com.hw1.springhw1.service.impl.UserServiceImpl;
import com.hw1.springhw1.utitl.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserRestController {

    private UserServiceImpl userService;
    private CommonUtils commonUtils;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCommonUtils(CommonUtils commonUtils) {
        this.commonUtils = commonUtils;
    }

    //    @GetMapping("/users")
//    {}
    @GetMapping("/hi")
    public String hi() {
        return "Hello";
    }

    @PostMapping("/users")
    public ResponseEntity<BaseApiResponse<UserRest>> insert(
            @RequestBody UserRequestModel user
    ) {
        BaseApiResponse<UserRest> response = new BaseApiResponse<>();
        UserDto userDto = commonUtils.getMapper().map(user, UserDto.class);
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        UserDto insertedUser = userService.insert(userDto);
        UserRest userRest = commonUtils.getMapper().map(insertedUser, UserRest.class);
        response.setMessage(Messages.Success.INSERT_SUCCESS.getMessage());
        response.setData(userRest);
        response.setStatus(HttpStatus.OK);
        response.setTime(commonUtils.getCurrentTime());
        return ResponseEntity.ok(response);
    }

}
