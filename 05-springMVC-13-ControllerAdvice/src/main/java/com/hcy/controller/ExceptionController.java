package com.hcy.controller;

import com.hcy.enxeption.SingletonDogEnception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class ExceptionController {
    @RequestMapping("system")
    public void testSystem(){
        int num=1/0;
    }

    @RequestMapping("custom")
    public void testCustom() throws SingletonDogEnception {
        throw new StringIndexOutOfBoundsException("单身狗");
    }

}
