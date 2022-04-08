package com.hcy.controller;

import com.github.pagehelper.PageHelper;
import com.hcy.entity.User;
import com.hcy.service.UserService;
import com.hcy.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //查询全部
    @RequestMapping("findAll")
    public List<User> findAll() {

        return userService.findAll();
    }

    //根据id进行删除
    @RequestMapping("del")
    public Map<String, Object> delById(Long id) {

        return userService.delByID(id);
    }

    //添加用户
    @RequestMapping("insert")
    public Map<String, Object> insertUser(User user) {
        return userService.insertUser(user);
    }

    //分页查询
    @RequestMapping("selectLimit")
    public Map<String, Object> selectLimit(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        return userService.selectLimit(pageNum, pageSize);
    }


    //修改
    @RequestMapping("updateUser")
    public Map<String, Object> updateUser(User user) {
        return userService.updateUser(user);
    }
}
