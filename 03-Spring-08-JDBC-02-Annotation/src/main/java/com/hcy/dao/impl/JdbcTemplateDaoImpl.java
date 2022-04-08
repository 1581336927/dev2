package com.hcy.dao.impl;

import com.hcy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcTemplateDaoImpl {


    public List<User> findAll() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    public Integer findCount() {
        String sql = "select count(*) from user";

        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);

        return integer;
    }

    public User findId(Integer id) {
        String sql = "select * from user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Autowired
    //这个对象类似queryrunner
    private JdbcTemplate jdbcTemplate;
}
