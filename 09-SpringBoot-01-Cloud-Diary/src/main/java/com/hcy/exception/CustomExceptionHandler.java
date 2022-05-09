package com.hcy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;


//全局异常拦截器
@RestControllerAdvice
public class CustomExceptionHandler {
    // 此注解用于处理对应类型的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handlerSystem(Exception e) {
        ModelAndView view = new ModelAndView();
        view.setViewName("/error/**");
        return view;
    }

}
