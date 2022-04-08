package com.hcy.advice;

import com.hcy.util.CustomFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.net.BindException;
import java.util.Date;

@ControllerAdvice
public class DataBindAdvice {
    //所有的方法到达Controller之前都会执行此方法
    @InitBinder
    public void ParseData(WebDataBinder binder){
        //添加自定义的格式化器
        binder.addCustomFormatter(new CustomFormatter());

    }

    @InitBinder("student")
    public void bindStudent(WebDataBinder binder){
        binder.setFieldDefaultPrefix("student.");
    }

    @InitBinder("teacher")
    public void binTeacher(WebDataBinder binder){
        binder.setFieldDefaultPrefix("teacher.");
    }
    //指定映射的参数名
    @ModelAttribute("createDataTime")
    public Date getCreateDataTime(){
        System.out.println("Controller执行之前");
        return  new Date();
    }
}
