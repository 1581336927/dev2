package com.hcy.controller;

import com.hcy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 使用@RequestMapping注解声明访问的一级路径
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("getUser")
    public String  getUser(User user) {
        System.out.println(user);
        return "/success.jsp";
    }

}

