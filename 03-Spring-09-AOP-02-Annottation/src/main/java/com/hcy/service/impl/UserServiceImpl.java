package com.hcy.service.impl;

import com.hcy.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加了一个新的用户：爷傲奈我何");

    }

    @Override
    public void update() {
        int num = 1 / 0;
        System.out.println("修改了用户的信息：爷傲奈我何");

    }
}
