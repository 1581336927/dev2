package com.hcy.dao.impl;

import com.hcy.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("oracle连接");
    }
}
