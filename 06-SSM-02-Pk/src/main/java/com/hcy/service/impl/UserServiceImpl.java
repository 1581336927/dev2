package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.hcy.dao.UserMapper;
import com.hcy.entity.Poor;
import com.hcy.entity.User;
import com.hcy.service.UserService;
import com.hcy.util.MyBatisUtils;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public Map<String, Object> delByID(Long id) {

        Integer i = userMapper.deleteByPrimaryKey(id);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "失败");
        map.put("code", -1);
        map.put("success", false);
        map.put("data", "{}");

        if (i > 0) {
            map.put("message", "成功");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", "{}");
        }

        return map;
    }

    @Override
    public Map<String, Object> insertUser(User user) {
        Map<String, Object> map = new HashMap<>();
        int i = userMapper.insert(user);
        map.put("message", "失败");
        map.put("code", -1);
        map.put("success", false);
        map.put("data", "{}");
        if (i > 0) {
            map.put("message", "成功");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", "{}");
        }
        return map;
    }


    @Override
    public Map<String, Object> updateUser(User user) {

        Map<String, Object> map = new HashMap<>();
        int i = userMapper.updateByPrimaryKeySelective(user);
        map.put("message", "失败");
        map.put("code", -1);
        map.put("success", false);
        map.put("data", "{}");
        if (i > 0) {
            map.put("message", "成功");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", "{}");
        }
        return map;
    }

    @Override
    public Map<String, Object> selectLimit(Integer pageNum, Integer pageSize) {

        System.out.println(pageNum + ":" + pageSize);
        // 查询指定页中的多少条数据
        PageHelper.startPage(pageNum, pageSize);
        //执行sql语句
        List<User> list = userMapper.selectByExample(null);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "失败");
        map.put("code", -1);
        map.put("success", false);
        map.put("data", list);
        if (list != null) {
            map.put("message", "成功");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", list);
            map.put("pageNum", pageNum);
            map.put("pageSize", pageSize);
            map.put("总数", list.size());
        }
        return map;
    }
}





