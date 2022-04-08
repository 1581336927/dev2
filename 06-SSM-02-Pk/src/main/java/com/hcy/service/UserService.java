package com.hcy.service;

import com.github.pagehelper.PageHelper;
import com.hcy.entity.Poor;
import com.hcy.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    List<User> findAll();

    Map<String, Object> delByID(Long id);


    Map<String, Object> insertUser(User user);


    Map<String, Object> updateUser(User user);


    Map<String, Object> selectLimit(Integer pageNum, Integer pageSize);
}
