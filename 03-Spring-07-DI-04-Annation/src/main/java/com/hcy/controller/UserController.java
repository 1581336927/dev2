package com.hcy.controller;

import com.hcy.service.UserService;
import com.hcy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;



    public List<User> findAll(){
        return userService.findAll();
    }
}
