package com.hcy.controller;

import com.hcy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("transfer")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, readOnly = false)
    public String transfer(Integer from, Integer to, Integer money) {

        accountService.transferMoney(from, to, money);

        int num = 1 / 0;
        return "转账成功";
    }
}
