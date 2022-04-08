package com.hcy.service.impl;

import com.hcy.dao.UserDao;
import com.hcy.dao.impl.UserDaoOracleImpl;
import com.hcy.dao.impl.UserImpl;
import com.hcy.service.UserService;

public class UserServiceImpl implements UserService {
   private UserDao userDao;
    @Override
    public void userDataBser() {
        userDao.userDataBase();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
