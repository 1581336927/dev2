package com.hcy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cross")
//@CrossOrigin(originPatterns = ("*"),allowCredentials = "true")
public class CrossController {
    @RequestMapping("test")
    public String test() {

        return "请求成功";
    }
}
