package com.hcy.controller;

import com.hcy.entity.TbUser;
import com.hcy.service.UserService;
import com.hcy.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv){

        ResultVO vo =userService.login(user.getUsername(),user.getPassword());

        if (vo.getCode()==0){
            //登陆失败
            mv.addObject("resultInfo",vo);

            mv.setViewName("forward:/login.jsp");
        }else {
            //登陆成功
            session.setAttribute("user",vo.getData());

            Cookie cookie;

            if (remember!=null&&remember==1){
                cookie=new Cookie("JSESSIONID",session.getId());

                cookie.setMaxAge(30*60);
            }else {
                cookie=new Cookie("JSESSIONID",null);

                cookie.setMaxAge(-1);
            }

            response.addCookie(cookie);

            mv.setViewName("forward:/index/page");
        }

        return mv;
    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv,HttpServletRequest request,HttpServletResponse response){

        Cookie cookie = new Cookie("JSESSIONID", null);

        // 立即销毁cookie
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        HttpSession session = request.getSession();

        session.removeAttribute("user");

        // 销毁session
        session.invalidate();

        // 重定向到登录页面
        mv.setViewName("redirect:/login.jsp");
        return mv;
    }
    @GetMapping("userCenter")
    public ModelAndView userCenter(HttpServletRequest request,ModelAndView mv){

        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");

        mv.addObject("menu_page",user);

        mv.addObject("changePage","/user/info.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;

    }

    @PostMapping("update")
    public ModelAndView update(TbUser user, MultipartFile img, ModelAndView mv, HttpSession session) {
        ResultVO vo = userService.update(img, user);

        // 只要更新成功，就需要同步更新域对象中的user
        if (vo.getCode() == 1) {
            session.setAttribute("user", vo.getData());
        }

        mv.setViewName("redirect:userCenter");

        return mv;
    }


    @GetMapping("checkNick")
    @ResponseBody
    public Integer checkNick(String nick){


        return  userService.checkNick(nick);
    }
}
