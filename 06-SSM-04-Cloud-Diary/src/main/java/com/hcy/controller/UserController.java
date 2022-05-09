package com.hcy.controller;

import com.hcy.entity.TbUser;
import com.hcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

   @GetMapping("logout")
    public ModelAndView loginOut(HttpServletRequest request,HttpServletResponse response){
       return userService.loginOut(request,response);
   }

   @GetMapping("userCenter")
   @PostMapping("userCenter")
    public ModelAndView userCenter(HttpServletRequest request,HttpServletResponse response){
       return userService.userCenter(request,response);
   }

   @PostMapping("update")
    public ModelAndView updateUser(@RequestParam("img") MultipartFile file,HttpServletRequest request,String nick,String mood){
       return userService.updateUser(file,request,nick,mood);
   }

   @GetMapping("checkNick")
    public Integer checkNick(String nick){
       return userService.checkNick(nick);

   }


}
