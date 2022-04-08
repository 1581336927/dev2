package com.hcy.Service.impl;

import com.hcy.Service.AccountService;
import com.hcy.dao.AccountDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ProgrammingSercice implements AccountService {
    private TransactionTemplate transactionTemplate;

    private AccountDao accountDao;
    @Override
    public void transfer(Integer from, Integer to, Long money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                accountDao.decreaseMoney(from,money);
                int num=1/0;
                accountDao.increaseMoney(to,money);
            }
        });
    }


    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
