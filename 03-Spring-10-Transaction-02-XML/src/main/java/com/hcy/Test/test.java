package com.hcy.Test;

import com.hcy.Service.AccountService;
import com.hcy.Service.Impl.StatementServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService service = context.getBean(StatementServiceImpl.class);

        service.transfer(1,2,300L);
    }
}
