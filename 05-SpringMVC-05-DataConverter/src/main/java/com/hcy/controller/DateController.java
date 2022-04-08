package com.hcy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("date")
public class DateController {
    @RequestMapping("getString")
    public void getString(String date){
        System.out.println(date);

    }

@RequestMapping("getDate")
    public void getDate(Date date){
        System.out.println(date);

    }
}
