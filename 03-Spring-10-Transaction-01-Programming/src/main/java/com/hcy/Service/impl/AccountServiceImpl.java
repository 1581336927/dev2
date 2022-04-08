package com.hcy.Service.impl;

import com.hcy.Service.AccountService;
import com.hcy.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Override
    public void transfer(Integer from, Integer to, Long money) {
        accountDao.decreaseMoney(from,money);

        accountDao.increaseMoney(to,money);

    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
