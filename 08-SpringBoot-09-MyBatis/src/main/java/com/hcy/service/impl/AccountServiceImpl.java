package com.hcy.service.impl;

import com.hcy.dao.AccountDao;
import com.hcy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public void transferMoney(Integer from, Integer to, Integer money) {
        accountDao.decrease(from,money);
        accountDao.decrease(to,money);
    }
}
