package com.hcy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerUserController {
    @RequestMapping("hello")
    public String hello(){
        return "李豪和蜥蜴的爱情故事";
    }
}
