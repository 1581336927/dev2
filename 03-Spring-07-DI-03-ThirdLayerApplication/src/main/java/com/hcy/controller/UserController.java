package com.hcy.controller;

import com.hcy.service.UserService;
import com.hcy.entity.User;

import java.util.List;

public class UserController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<User> findAll(){
        return userService.findAll();
    }
}
