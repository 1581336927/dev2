package com.hcy.test;

import com.hcy.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test() {
        UserDaoImpl userDao = new UserDaoImpl();

        userDao.findAll();
    }
}
