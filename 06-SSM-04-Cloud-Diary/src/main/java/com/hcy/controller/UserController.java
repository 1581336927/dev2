package com.hcy.controller;

import com.hcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

   @PostMapping("login")
    public ModelAndView login(String username, String password, @RequestParam(defaultValue = "0") Integer remember, HttpServletRequest request, HttpServletResponse response){
       return userService.login(username,password,remember,request,response);
   }

   @GetMapping("loginOut")
    public ModelAndView loginOut(HttpServletRequest request,HttpServletResponse response){
       return userService.loginOut(request,response);
   }

   @GetMapping("userCenter")
    public ModelAndView userCenter(HttpServletRequest request,HttpServletResponse response){
       return userService.userCenter(request,response);
   }
}
