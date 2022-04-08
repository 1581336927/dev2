package com.hcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//将本类注入到容器中

@Controller
@RequestMapping("user")
public class UserComtroller {

    @RequestMapping(path = "login")
    public String login(){
        System.out.println("add");
        return "/login.jsp";
    }
}
