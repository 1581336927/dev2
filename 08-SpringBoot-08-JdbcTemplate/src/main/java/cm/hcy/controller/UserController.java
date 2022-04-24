package cm.hcy.controller;

import cm.hcy.entity.User;
import cm.hcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<User> findAll() {

        return userService.findAll();
    }

    @RequestMapping("findById")
    public User findById(@RequestParam Integer id) {
        return userService.findById(id);
    }

    @RequestMapping("findCount")
    public Map<String, Object> findCount() {
        Map<String, Object> map = new HashMap<>();
        Integer count = userService.findCount();
        if (count>0){
            map.put("code",200);
            map.put("message","查询总数成功");
            map.put("success",true);
            map.put("count",count);
        }else {
            map.put("code",-1);
            map.put("message","查询总数失败");
            map.put("success",false);
            map.put("count",null);
        }


        return map;
    }

    @RequestMapping("insert")
    public Map<String, Object> insert(User user) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = userService.insert(user);
        if (integer>0){
            map.put("code",200);
            map.put("message","插入总数成功");
            map.put("success",true);
            map.put("integer",integer);
        }else {
            map.put("code",-1);
            map.put("message","插入总数失败");
            map.put("success",false);
            map.put("count",null);
        }

        return map;
    }

    @RequestMapping("update")
    public Map<String, Object> update(User user) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = userService.update(user);
        if (integer>0){
            map.put("code",200);
            map.put("message","修该用户成功");
            map.put("success",true);
            map.put("integer",integer);
        }else {
            map.put("code",-1);
            map.put("message","修该用户失败");
            map.put("success",false);
            map.put("count",null);
        }

        return map;
    }

    @RequestMapping("delete")
    public Map<String, Object> delete(@RequestParam Integer id) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = userService.delete(id);
        if (integer>0){
            map.put("code",200);
            map.put("message","删除成功");
            map.put("success",true);
            map.put("integer",integer);
        }else {
            map.put("code",-1);
            map.put("message","删除失败");
            map.put("success",false);
            map.put("count",null);
        }

        return map;
    }
}
