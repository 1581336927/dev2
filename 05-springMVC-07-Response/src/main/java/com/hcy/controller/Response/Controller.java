package com.hcy.controller.Response;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcy.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@org.springframework.stereotype.Controller
@RequestMapping("response")
public class Controller {
    @RequestMapping("test")
    public void test() {
        System.out.println("void错误解析");
    }


    @RequestMapping("testString")
    public String testString() {
        System.out.println("String返回值直接跳转");
        return "/success.jsp";
    }


    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView view = new ModelAndView();

        view.addObject("username", "哈哈");

        view.setViewName("/success.jsp");
        return view;
    }


    @RequestMapping("testModelAndView2")
    public ModelAndView testModelAndView2(ModelAndView modelAndView) {

        modelAndView.addObject("username", "玩的化");

        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }


    @RequestMapping("testModelAndView3")
    public String testModelAndView3(Model model) {

        model.addAttribute("username", "会带好的");
        return "/success.jsp";
    }


    @RequestMapping("testVoidRedirect")
    public void testVoidRedirect(HttpServletResponse response) {
        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("testForWard")
    public void testForWard(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.setAttribute("username", "韩晨宇");
        try {
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testStringRedirect")
    public String testStringRedirect() {
        return "redirect/success.jsp";
    }

    @RequestMapping("testStringForWard")
    public String testStringForWard(Model model) {
        model.addAttribute("username", "江南七怪");

        return "forward:/success.jsp";
    }

    //Response注解会自动视图解析器

    //并且返回json类型的数据
    @RequestMapping("testResponseBody")
    @ResponseBody
    public void testResponseBody() {
        System.out.println("测试responsebody响应");

    }


    @RequestMapping("testStringResponseBody")
    @ResponseBody
    public String testStringResponseBody() {
//如果使用字符串返回相当于调用了resp.getwrite(/success.jsp)
        return "/success.jsp";

    }


    @RequestMapping(value = "testHtmlResponseBody", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testHtmlResponseBody() {

        return "<h1>美丽的泡沫</h1>";


    }


    @RequestMapping(value = "testJsonResponseBody", produces = "application/json;")
    @ResponseBody
    public String testJsonResponseBody() {

        return "{\"username\":\"易烊千玺\",\"password\":\"123456\"}";

    }


    @RequestMapping(value = "testObjectResponseBody", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String testObjectResponseBody() {

        User user = new User();

        user.setName("易烊千玺");
        user.setAge(20);
        user.setGender("男");
        user.setInfo("多才多艺");
        user.setDate(new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(user);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


    @RequestMapping(value = "testUserResponseBody", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User testUserResponseBody() {

        User user = new User();

        user.setName("易烊千玺");
        user.setAge(20);
        user.setGender("男");
        user.setInfo("多才多艺");
        user.setDate(new Date());


        return user;
    }


    @RequestMapping(value = "testMapResponseBody", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> testMapResponseBody() {

        List<Object> list = new ArrayList<>();

        list.add("靠麦片");
        list.add("烤红薯");
        User user = new User();

        user.setName("易烊千玺");
        user.setAge(20);
        user.setGender("男");
        user.setInfo("多才多艺");
        user.setDate(new Date());


        Map<String, Object> map = new HashMap<>();

        map.put("code",200);
        map.put("success","成功");
        map.put("data",user);

        map.put("food",list);

        return map;
    }
}
