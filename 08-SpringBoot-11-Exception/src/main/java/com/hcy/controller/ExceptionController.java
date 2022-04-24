package com.hcy.controller;

import com.hcy.exeception.SingletonException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class ExceptionController {

    @RequestMapping("system")
    public String testException() {
        int num = 1 / 0;
        return "没问题";
    }


    @RequestMapping("singleton")
    public void singletonException() throws SingletonException {

        throw new SingletonException("单身狗异常");
    }
}
