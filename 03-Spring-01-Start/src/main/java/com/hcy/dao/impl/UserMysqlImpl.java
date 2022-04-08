package com.hcy.dao.impl;

import com.hcy.dao.UserDao;

public class UserMysqlImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("mysql连接");
    }
}
