package com.hcy.enxeption;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class MyHandlerException implements HandlerExceptionResolver {

    //如果发生异常，都会执行这个方法
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView modelAndView = new ModelAndView();

        if (ex instanceof SingletonDogEnception) {
            modelAndView.addObject("message", "两个黄鹂鸣翠柳，你还没有女朋友");
        } else {
            modelAndView.addObject("message", ex.getMessage());
        }

        modelAndView.setViewName("/error.jsp");

        return modelAndView;
    }
}
