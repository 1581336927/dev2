package com.hcy.dao.impl;

import com.hcy.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void userDataBase() {
        System.out.println("使用oracle连接数据库");
    }
}
