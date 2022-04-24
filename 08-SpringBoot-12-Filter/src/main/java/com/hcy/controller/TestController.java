package com.hcy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("filter")
    public String testFilter(){
        return "过滤前被执行";
    }
}
