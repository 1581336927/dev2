package com.hcy.service.impl;

import com.hcy.service.UserService;
import com.hcy.dao.UserDao;
import com.hcy.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
