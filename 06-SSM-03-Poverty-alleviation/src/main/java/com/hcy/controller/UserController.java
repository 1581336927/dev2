package com.hcy.controller;

import com.hcy.service.UserService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hcy.entity.User;
import javax.annotation.PostConstruct;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("getlist")
    public ResultVo getlist(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Long id){

        return userService.getlist(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo add(@RequestBody User user){

        return userService.add(user);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody User user){
        return userService.update(user);
    }
    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id){
        return userService.delete(id);
    }
}
