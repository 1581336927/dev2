package com.hcy.service;

import com.hcy.dao.UserDao;
import com.hcy.dao.UserServiceImpl;

public class UserService  {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private void add(){
        System.out.println("add=========");
        UserDao service =  new UserServiceImpl();
        userDao.update();
    }
}
