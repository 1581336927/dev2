package com.hcy.controller;

import com.hcy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@Controller
public class AnnotcationController {

    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "userId", required = true, defaultValue = "1") String id) {

        System.out.println("获取到的参数" + id);
        return "/index.jsp";

    }

    @RequestMapping("page")
    public String page(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        System.out.println(pageNo + "+" + pageSize);
        return "/index.jsp";

    }


    @RequestMapping("keyword")
    public String keyword(@RequestParam(value = "pageNo", defaultValue = "") String name,
                          Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "") String gender,
                          Integer pageSize) {
        System.out.println(pageNo + "+" + pageSize + name + gender);
        return "/index.jsp";

    }

    @GetMapping (value = "user/{id}")
    public String getUser(@PathVariable("id") Integer id){

        System.out.println("查询的学生"+id);

        return "/index.jsp";

    }


    @DeleteMapping(value = "user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        System.out.println("删除的学生"+id);

        return "/index.jsp";

    }

    @PostMapping(value = "user/{id}")
    public String addUser(@PathVariable("id") Integer id){

        System.out.println("添加的学生"+id);

        return "/index.jsp";

    }


    @PutMapping(value = "user/{id}")
    public String updateUser(@PathVariable("id") Integer id){

        System.out.println("修改的学生"+id);

        return "/index.jsp";

    }

    @RequestMapping("testJson")
    public String testJson(@RequestBody String json){
        System.out.println(json);
        return "/index.jsp";
    }


    @RequestMapping("testUser")
    public String testUser(@RequestBody User user){
        System.out.println(user);
        return "/index.jsp";
    }
}
