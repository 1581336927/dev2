package com.hcy.dao.impl;

import com.hcy.dao.UserDao;
import com.hcy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDaoMysql")
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(1,"派大星","123456"));
        list.add(new User(2,"花园宝宝","888888"));
        list.add(new User(3,"汤布力不","123456"));


        return list;
    }
}
