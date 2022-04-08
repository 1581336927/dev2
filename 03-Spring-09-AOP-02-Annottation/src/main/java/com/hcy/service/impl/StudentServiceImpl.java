package com.hcy.service.impl;

import com.hcy.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加了一个学生......");
    }

    @Override
    public void update() {
        System.out.println("修改一个学生.......");
    }
}
