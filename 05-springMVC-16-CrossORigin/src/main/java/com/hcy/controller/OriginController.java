package com.hcy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("crossOrigin")
@RestController
public class OriginController {
    public Map<String, Object> get(){

        Map<String, Object> map=new HashMap<>();

        map.put("code",200);
        map.put("message","跨域请求成功");

        return  map;
    }
}
