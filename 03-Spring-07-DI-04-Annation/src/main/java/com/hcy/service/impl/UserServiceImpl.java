package com.hcy.service.impl;

import com.hcy.service.UserService;
import com.hcy.dao.UserDao;
import com.hcy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoMysql")
    //既根据id又根据注解
@Resource(name = "userDaoMysql")
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}
