package com.hcy.controller;

import com.hcy.entity.Clazz;
import com.hcy.entity.User;
import com.hcy.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 使用@RequestMapping注解声明访问的一级路径
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("register")
    public String register(User user) {
        System.out.println(user);

        return "/success.jsp";
    }
    @RequestMapping("testNestedObject")
    public String testNestedObject(UserInfo userInfo){
        System.out.println(userInfo);
        return "/success.jsp";

    }


    @RequestMapping("testListAndMap")
    public String testListAndMap(Clazz clazz){
        System.out.println(clazz);
        return "/success.jsp";

    }

    @RequestMapping("testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        request.getSession(true).setAttribute("username",username);

        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}

