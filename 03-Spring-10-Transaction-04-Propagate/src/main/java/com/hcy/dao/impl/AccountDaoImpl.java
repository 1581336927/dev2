package com.hcy.dao.impl;

import com.hcy.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void add(String name) {
        getJdbcTemplate().update("insert into account(name) values (?)", name);
    }
}
