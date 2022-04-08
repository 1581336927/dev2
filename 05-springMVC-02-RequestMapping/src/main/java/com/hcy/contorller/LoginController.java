package com.hcy.contorller;

import com.hcy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 使用@RequestMapping注解声明访问的一级路径
@Controller
@RequestMapping("user")
public class LoginController {

    @RequestMapping("register")
    public String register(String name,Integer age, String birthday, String info) {
        System.out.println("姓名：" + name + " 年龄：" + age + " 生日：" + birthday + " 信息：" + info);

        return "/success.jsp";
    }


    @RequestMapping("register1")
    public String tset(User user) {
        System.out.println(user);

        return "/success.jsp";
    }
}