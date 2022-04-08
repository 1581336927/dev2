package com.hcy.test;

import com.hcy.Service.AccountService;
import com.hcy.Service.impl.ProgrammingSercice;
import com.hcy.dao.AccountDao;
import com.hcy.dao.impl.AccountDaoImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService service = context.getBean(ProgrammingSercice.class);

        service.transfer(2,1,100L);
    }
}
