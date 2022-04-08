package com.hcy.test;

import com.hcy.dao.impl.UserDaoOracleImpl;
import com.hcy.dao.impl.UserImpl;
import com.hcy.service.UserService;
import com.hcy.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserService userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoOracleImpl());
        userService.userDataBser();
    }
}
