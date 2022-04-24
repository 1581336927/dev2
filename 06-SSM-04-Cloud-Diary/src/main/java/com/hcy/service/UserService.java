package com.hcy.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {


    ModelAndView login(String username, String password, Integer remember, HttpServletRequest request, HttpServletResponse response);

    ModelAndView loginOut(HttpServletRequest request,HttpServletResponse response);


    ModelAndView userCenter(HttpServletRequest request, HttpServletResponse response);
}
