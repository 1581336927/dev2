package com.hcy.controller;

import com.hcy.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("controller")
public class TestRestController {
    @RequestMapping("testUsers")
    public User testUser(){
        return new User("易烊千玺",22,"男",new Date(),"美类呀此拉着");
    }
}
