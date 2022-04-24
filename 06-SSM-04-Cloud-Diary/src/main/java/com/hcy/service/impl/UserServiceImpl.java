package com.hcy.service.impl;

import com.hcy.dao.TbUserMapper;
import com.hcy.entity.TbUser;
import com.hcy.service.UserService;
import com.hcy.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public ModelAndView login(String username, String password, Integer remember, HttpServletRequest request, HttpServletResponse response) {

        //获取视图解析器
        ModelAndView view = new ModelAndView();
        //执行sql语句
        TbUser user = userMapper.select(username, password);
        //展示数据
        ResultInfo resultInfo = new ResultInfo(0, "登陆失败,密码或账号错误", null);
        //判断用户名或密码为空的情况下
        if (username == null || password == null) {
            view.addObject("resultInfo", resultInfo);
            view.setViewName("/login.jsp");
        }
        //如果没有查到数据
        if (user == null) {
            view.addObject("resultInfo", resultInfo);
            view.setViewName("/login.jsp");
            //否则跳转到主页
        } else {
            // 登录成功，创建session
            HttpSession session = request.getSession(true);
            // 将实体类对象作为值添加到session中
            session.setAttribute("user", user);

            session.setMaxInactiveInterval(60 * 30);
            //获取session的id
            String id = session.getId();
            //使用JSESSIONID和session的id作为键值对创建cookie对象
            Cookie cookie = new Cookie("JSESSIONID", id);
            if (remember == 0) {
                cookie.setMaxAge(-1);
            } else {
                //设置cookie的过期时间
                cookie.setMaxAge(30 * 60);
            }
            //发送给浏览器
            response.addCookie(cookie);
            view.setViewName("/index.jsp");
        }

        return view;
    }

    @Override
    public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) {
        //获取session
        HttpSession session = request.getSession(false);

        ModelAndView view = new ModelAndView();
        if (session != null) {
            session.invalidate();

            //根据JSESSIONID获取cookie
            Cookie cookie = new Cookie("JSESSIONID", session.getId());

            //设置cookie销毁
            cookie.setMaxAge(0);

            //发送到浏览器
            response.addCookie(cookie);

        }
//        try {
//            //重定向至登陆页面
//            response.sendRedirect("login.jsp");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        view.setViewName("/login.jsp");

        return view;
    }

    @Override
    public ModelAndView userCenter(HttpServletRequest request, HttpServletResponse response) {


        return null;
    }
}
