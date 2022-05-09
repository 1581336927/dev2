package com.hcy.service.impl;

import com.hcy.dao.TbUserMapper;
import com.hcy.entity.TbUser;
import com.hcy.service.UserService;
import com.hcy.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


        view.setViewName("redirect:/login.jsp");

        return view;
    }

    @Override
    public ModelAndView userCenter(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView();
        //获取session这里注意需要参数false
        HttpSession session = request.getSession(false);
        //拿到session域对象中强转为TbUser实体类
        TbUser user = (TbUser) session.getAttribute("user");
        //设置请求域对象
        request.setAttribute("menu_page", user);
        request.setAttribute("changePage", "/user/info.jsp");
        //转发页面
        view.setViewName("forward:/index.jsp");

        return view;
    }

    @Override
    public ModelAndView updateUser(MultipartFile file, HttpServletRequest request, String nick, String mood) {

        ModelAndView view = new ModelAndView();

        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");
        if (!file.isEmpty()) {

            //准备文件存储的路径
            String path = "C:\\Users\\HCY\\Desktop\\JavaMd\\15_Tomcat\\apache-tomcat2-8.5.37\\webapps\\upload\\poverty-Alleviation\\";

            File pathFile = new File(path);

            if (!pathFile.exists()) {
                //创建多级路径
                pathFile.mkdirs();
            }

            //获取原始的文件名
            String originalFilename = file.getOriginalFilename();

            //获取时间的格式化器
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            //获取格式化之后的当前日期时间
            String format = formatter.format(new Date());

            //获取文件的后缀名
            String suufix = originalFilename.substring(originalFilename.lastIndexOf("."));

            //新的文件名等于格式化之后的日期时间加上后缀名
            originalFilename = format + suufix;

            System.out.println(originalFilename);

            Integer integer = userMapper.updateImg(originalFilename, user.getId());

            if (integer>0){
                view.setViewName("forward:/index.jsp");
            }


            try {
                //文件上传操作
                file.transferTo(new File(pathFile, originalFilename));
            } catch (IOException e) {
                e.printStackTrace();

            }

        } else {

            Integer inffectedRows = userMapper.update(nick, mood, user.getId());

            System.out.println(inffectedRows);


            view.setViewName("forward:/index.jsp");

            TbUser tbUser = userMapper.selectByPrimaryKey(user.getId());

            session.setAttribute("user", tbUser);

        }
        return view;

    }

    @Override
    public Integer checkNick(String nick) {

        List<TbUser> list = userMapper.selectNick(nick);

        if (list!=null){
            return 0;
        }else {

            return 1;
        }
    }

}
