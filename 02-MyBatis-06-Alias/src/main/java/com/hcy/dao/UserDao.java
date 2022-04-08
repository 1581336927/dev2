package com.hcy.dao;

import com.hcy.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectUser();
}
