package com.hw1.springhw1.repository.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDto implements UserDetails {

    private int id;

    private String username;
    private String password;

    private List<com.hw1.springhw1.repository.dto.RoleDto> roles;

    public UserDto() {}

    public UserDto(
                   String username,
                   String password,
                   List<com.hw1.springhw1.repository.dto.RoleDto> roles) {

        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<com.hw1.springhw1.repository.dto.RoleDto> roles) {
        this.roles = roles;
    }

    public List<com.hw1.springhw1.repository.dto.RoleDto> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +

                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
