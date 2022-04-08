package com.hcy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @RequestMapping("getFoods")
    public ModelAndView getFoods(ModelAndView mv){
        //模拟连接数据库
        List<String> list = new ArrayList<>();
        list.add("金枪鱼");
        list.add("龙虾尾");
        list.add("麻辣烫");
        mv.addObject("foods",list);
        mv.setViewName("/account/getFoods");
        return mv;
    }
}
