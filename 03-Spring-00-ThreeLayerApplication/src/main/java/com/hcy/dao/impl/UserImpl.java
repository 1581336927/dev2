package com.hcy.dao.impl;

import com.hcy.dao.UserDao;

public class UserImpl implements UserDao {
    @Override
    public void userDataBase() {
        System.out.println("连接数据库");
    }
}
