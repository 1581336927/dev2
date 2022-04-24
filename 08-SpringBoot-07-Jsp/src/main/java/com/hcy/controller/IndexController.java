package com.hcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("test")
    public String test(Model model){
        model.addAttribute("username","李豪爱蜥蜴");

        return "index";
    }
}
