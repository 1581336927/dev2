package com.hcy.advice;

import com.hcy.enxeption.SingletonDogEnception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAdvice {
    //只要发生了这个异常，就会执行此方法
    @ExceptionHandler(SingletonDogEnception.class)
    @ResponseBody
    public Map<String, Object> handleSingletonDogException(Exception exception){

       Map<String, Object> map= new HashMap<>();

        map.put("code","-1");
        map.put("message","路见不平一声吼");
        map.put("success",false);
        map.put("data",exception.getMessage());

        return map;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(Exception exception) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", "-1");
        map.put("message", exception.getMessage());
        map.put("success", false);
        map.put("data", exception.getMessage());

        return map;
    }
}
