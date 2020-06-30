package com.hw1.springhw1.restcontroller.request;



import com.hw1.springhw1.repository.dto.RoleDto;

import java.util.List;

public class UserRequestModel {

    private String username;
    private String password;

    private List<RoleDto> roles;

    public UserRequestModel() {}

    public UserRequestModel(String username,
                            String password,
                            List<RoleDto> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }
}
